package cn.com.serialize;

import cn.com.exception.JRedisCacheException;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import de.javakaffee.kryoserializers.*;
import de.javakaffee.kryoserializers.cglib.CGLibProxySerializer;
import javolution.util.FastTable;

import java.lang.reflect.InvocationHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.GregorianCalendar;

/**
 * Kryo的包装
 */
public class KryoPoolSer {

    /**
     * kryo的包装
     */
    private static class KryoHolder {
        private Kryo kryo;
        static final int BUFFER_SIZE = 1024;
        private Output output = new Output(BUFFER_SIZE, -1);
        private Input input = new Input();

        KryoHolder(Kryo kryo) {
            this.kryo = kryo;

            // register
            this.kryo.register(Arrays.asList("").getClass(), new ArraysAsListSerializer());
            this.kryo.register(Collections.EMPTY_LIST.getClass(), new CollectionsEmptyListSerializer());
            this.kryo.register(Collections.EMPTY_MAP.getClass(), new CollectionsEmptyMapSerializer());
            this.kryo.register(Collections.EMPTY_SET.getClass(), new CollectionsEmptySetSerializer());
            this.kryo.register(Collections.singletonList("").getClass(), new CollectionsSingletonListSerializer());
            this.kryo.register(Collections.singleton("").getClass(), new CollectionsSingletonSetSerializer());
            this.kryo.register(Collections.singletonMap("", "").getClass(), new CollectionsSingletonMapSerializer());
            this.kryo.register(GregorianCalendar.class, new GregorianCalendarSerializer());
            this.kryo.register(InvocationHandler.class, new JdkProxySerializer());
            this.kryo.register(CGLibProxySerializer.CGLibProxyMarker.class, new CGLibProxySerializer());
            UnmodifiableCollectionsSerializer.registerSerializers(this.kryo);
            SynchronizedCollectionsSerializer.registerSerializers(this.kryo);
        }
    }

    interface KryoPool {

        /**
         * get a kryo object
         * @return
         */
        KryoHolder get();

        /**
         * return object
         * @param kryo
         */
        void offer(KryoHolder kryo);
    }

    /**
     * 基于kryo的序列化方案
     *
     * 由于kryo创建的代价较高，这里使用空间交换时间
     * 对KryoHolder对象进行重用
     * KryoHolder会出现峰值，应该不会造成内存泄漏
     */
    public static class KryoPoolImpl implements KryoPool {

        /**
         * thread safe list
         */
        private final FastTable<KryoHolder> kryoFastTable = new FastTable<KryoHolder>().atomic();

        private KryoPoolImpl() {

        }

        /**
         * 单例
         * @return
         */
        public static KryoPool getInstance() {
            return Singleton.pool;
        }

        /**
         * get a KryoHolder object
         * @return
         */
        @Override
        public KryoHolder get() {
            //Retrieves and removes the head of the queue represented by this table
            KryoHolder kryoHolder = kryoFastTable.pollFirst();
            return kryoHolder == null ? createInstance() : kryoHolder;
        }

        /**
         * return object
         * Inserts the specified element at the tail of this queue.
         * @param kryo
         */
        @Override
        public void offer(KryoHolder kryo) {
            kryoFastTable.addLast(kryo);
        }

        /**
         * create a new kryo object to application use
         * @return
         */
        public KryoHolder createInstance() {
            Kryo kryo = new Kryo();
            kryo.setReferences(false);
            return new KryoHolder(kryo);
        }

        private static class Singleton {
            private static final KryoPool pool = new KryoPoolImpl();
        }
    }

    /**
     * 将对象序列化成字节数组
     * @param obj
     * @return
     */
    public byte[] objSerialize(Object obj) {
        KryoHolder kryoHolder = null;
        if (obj == null) {
            throw new JRedisCacheException("obj can not be null");
        }
        try {
            kryoHolder = KryoPoolImpl.getInstance().get();
            kryoHolder.output.clear();      //clear output  --->每次调用的时候，重置
            kryoHolder.kryo.writeClassAndObject(kryoHolder.output, obj);
            return kryoHolder.output.toBytes();
        } catch (JRedisCacheException e) {
            throw new JRedisCacheException("Serialize obj exception");
        } finally {
            KryoPoolImpl.getInstance().offer(kryoHolder);
        }
    }

    /**
     * 将字节数组反序列化为对象
     * @param bytes
     * @return
     */
    public Object objDeserialize(byte[] bytes) {
        KryoHolder kryoHolder = null;
        if (bytes == null) {
            throw new JRedisCacheException("bytes can not be null");
        }
        try {
            kryoHolder = KryoPoolImpl.getInstance().get();
            kryoHolder.input.setBuffer(bytes, 0, bytes.length);  //call it,and then use input object, discard any array
            return kryoHolder.kryo.readClassAndObject(kryoHolder.input);
        } catch (JRedisCacheException e) {
            throw new JRedisCacheException("Deserialize bytes exception");
        } finally {
            KryoPoolImpl.getInstance().offer(kryoHolder);
        }
    }

    /**
     * 将字节数组反序列化为对象
     * @param bytes
     * @param length
     * @return
     */
    public Object kryoDeserialize(byte[] bytes, int length) {
        KryoHolder kryoHolder = null;
        if (bytes == null) {
            throw new JRedisCacheException("bytes can not be null");
        }
        try {
            kryoHolder = KryoPoolImpl.getInstance().get();
            kryoHolder.input.setBuffer(bytes, 0, length);
            return kryoHolder.kryo.readClassAndObject(kryoHolder.input);
        } catch (JRedisCacheException e) {
            throw new JRedisCacheException("Deserialize bytes exception");
        } finally {
            KryoPoolImpl.getInstance().offer(kryoHolder);
        }
    }
}
