package cn.com.GC;

/**
 * Created by xiaxuan on 16/8/26.
 */
public class MinorGCDemo {

    private static final int _1MB = 1024 * 1024;

    /**
     * VM 参数： -verbose:gc -Xms20M -Xmx20M -Xmn20M -XX:PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void testAllocation() {
        byte[] allocation1, alloctaion2, allocation3, alloctaion4;
        allocation1 = new byte[2 * _1MB];
        alloctaion2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        alloctaion4 = new byte[4 * _1MB];       //出现一次minor GC
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
