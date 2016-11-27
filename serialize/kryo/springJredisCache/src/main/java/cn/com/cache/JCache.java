package cn.com.cache;

import javolution.util.FastMap;
import javolution.util.FastTable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by xiaxuan on 16/11/26.
 */
public interface JCache {

    /**
     * 发布消息
     * @param channel
     * @param messge
     * @return
     */
    Long publish(String channel, byte[] messge);

    /**
     * 订阅指定的消息   订阅得到消息在BinaryJedisPubSub的onMessage(...)方法中进行处理
     * @param channels
     */
    void subscribe(String... channels);

    /**
     * 取消订阅的所有channel
     */
    void unsubscribe();

    /**
     * 取消订阅的channel
     * @param channels
     */
    void unsubscribe(String... channels);

    /**
     * 表达式的方式订阅
     * 使用模式匹配的方式设置要订阅的消息            订阅得到信息在BinaryJedisPubSub的onMessage(...)方法中进行处理
     *
     * @param patterns          订阅的消息类型
     */
    void psubscribe(String... patterns);

    /**
     * 取消所有订阅的channel
     */
    void punsubscribe();

    /**
    * 取消订阅的channel
    * @param patterns
    */
    void punsubscribe(String... patterns);


    /**
     * @return
     */
    String info();


    /**
     *
     * @param key
     * @param filed
     * @return
     */
    ArrayList<?> getList(String key,String filed);

    /**
     *
     * @param key
     * @param filed
     * @param list
     * @return
     */
    String putList(String key, String filed ,ArrayList<?> list);

    /**
     * @param key
     * @return
     * @
     */
    ArrayList<?> getList(String key);

    /**
     * @param key
     * @param list
     */
    String putList(String key, ArrayList<?> list);

    /**
     * Remove an item from the cache
     */
    void removeList(String key);


    /**
     * @param key
     * @return
     */
    FastTable<?> getFastTable(String key);


    /**
     * @param key
     * @param list
     */
    void putFastTable(String key, FastTable<?> list);

    /**
     * @param key
     * @return
     * @
     */
    FastMap<?, ?> getFastMap(String key);

    /**
     * Remove an item from the cache
     */
    void removeFastMap(String key);

    /**
     * @param key
     * @param fastMap
     */
    void putFastMap(String key, FastMap<?, ?> fastMap);

    /**
     * Get an item from the cache, nontransactionally
     *
     * @param key
     * @return the cached object or <tt>null</tt>
     * @throws JRedisCacheException
     */
    Serializable getObject(String key);

    /**
     * Add an item to the cache, nontransactionally, with
     * failfast semantics
     *
     * @param key
     * @param value
     * @
     */
    void putObject(String key, Serializable value);

    /**
     * Remove an item from the cache
     */
    void removeObject(String key);

    /**
     * @return
     * @throws JRedisCacheException
     */
    FastTable<String> keys();


    void destroy();

    /**
     * Queue
     *
     * @param key
     * @param value
     */
    void addQueue(String key, Serializable value);

    /**
     * poll  from queue
     *
     * @param key
     */
    Serializable pollFromQueue(String key);


    /**
     * peek  from queue
     *
     * @param key
     */
    Serializable peekFromQueue(String key);
}
