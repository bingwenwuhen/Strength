package cn.com.serialize;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import de.javakaffee.kryoserializers.*;
import de.javakaffee.kryoserializers.cglib.CGLibProxySerializer;

import java.lang.reflect.InvocationHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.GregorianCalendar;

/**
 * Created by xiaxuan on 16/11/26.
 */
public class KryoThreadLocalSer implements Serialization {

    private KryoThreadLocalSer() {

    }

    public static KryoThreadLocalSer getInstance() {
        return Singleton.kryoThreadLocal;
    }

    @Override
    public byte[] objSerialize(Object obj) {
        try {
            KryoHolder kryoHolder = kryoThreadLocal.get();
            kryoHolder.output.clear();
            kryoHolder.kryo.writeClassAndObject(kryoHolder.output, obj);
            return kryoHolder.output.toBytes();
        } finally {
            obj = null;
        }
    }

    @Override
    public Object ObjDeserialize(byte[] bytes) {
        KryoHolder kryoHolder = kryoThreadLocal.get();
        kryoHolder.input.setBuffer(bytes, 0, bytes.length);
        return kryoHolder.kryo.readClassAndObject(kryoHolder.input);
    }

    private static class Singleton {
        private static final KryoThreadLocalSer kryoThreadLocal = new KryoThreadLocalSer();
    }

    private final ThreadLocal<KryoHolder> kryoThreadLocal = new ThreadLocal<KryoHolder>(){
        @Override
        protected KryoHolder initialValue() {
            return new KryoHolder(new Kryo());
        }
    };

    private class KryoHolder {
        private Kryo kryo;
        static final int BUFFER_SIZE = 1024;
        private Output output = new Output(BUFFER_SIZE, -1);     //reuse
        private Input input = new Input();

        KryoHolder(Kryo kryo) {
            this.kryo = kryo;
            this.kryo.setReferences(false);

            //   register
            this.kryo.register(Arrays.asList("").getClass(), new ArraysAsListSerializer());
            this.kryo.register(Collections.EMPTY_LIST.getClass(), new CollectionsEmptyListSerializer());
            this.kryo.register(Collections.EMPTY_MAP.getClass(), new CollectionsEmptyMapSerializer());
            this.kryo.register(Collections.EMPTY_SET.getClass(), new CollectionsEmptySetSerializer());
            this.kryo.register(Collections.singletonList("").getClass(), new CollectionsSingletonListSerializer());
            this.kryo.register(Collections.singleton("").getClass(), new CollectionsSingletonSetSerializer());
            this.kryo.register(Collections.singletonMap("", "").getClass(), new CollectionsSingletonMapSerializer());
            this.kryo.register(GregorianCalendar.class, new GregorianCalendarSerializer());
            this.kryo.register(InvocationHandler.class, new JdkProxySerializer());
            // register CGLibProxySerializer, works in combination with the appropriate action in handleUnregisteredClass (see below)
            this.kryo.register(CGLibProxySerializer.CGLibProxyMarker.class, new CGLibProxySerializer());
            UnmodifiableCollectionsSerializer.registerSerializers(this.kryo);
            SynchronizedCollectionsSerializer.registerSerializers(this.kryo);

        }

    }
}
