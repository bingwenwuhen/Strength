package cn.com.GC;

/**
 * Created by xiaxuan on 16/8/26.
 * 大对象直接进入老年代
 */
public class MinorGCDemo2 {

    private static final int _1MB = 1024 * 1034;

    /**
     * VM参数: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];    //直接分配在老年代中
    }

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }
}
