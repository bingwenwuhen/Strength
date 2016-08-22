package cn.com.heap;

/**
 * Created by xiaxuan on 16/8/22.
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    //这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否被回收过
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;
        //假设在这里发生gc，objA和objB是否能回收？
        System.gc();
    }
}