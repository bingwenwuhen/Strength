package cn.com.GC;

/**
 * Created by xiaxuan on 16/8/27.
 */
public class MirrorGCDemo3 {

    private static final int _1MB = 1024 * 1024;

    public static void testTenuringThreshold() {
        byte[] allocation1,allocation2,allocation3;
        allocation1 = new byte[_1MB / 4];
        //什么时候进入老年代取决于XX:MaxTenuringThreshold设置
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testTenuringThreshold();
        System.gc();
    }
}
