package cn.com.serialize;

/**
 * Created by xiaxuan on 16/11/26.
 */
public interface Serialization {

    byte[] objSerialize(Object obj);

    Object ObjDeserialize(byte[] bytes);
}
