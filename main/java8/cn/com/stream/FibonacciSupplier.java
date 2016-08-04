package cn.com.stream;

import java.util.function.Supplier;

/**
 * Created by Administrator on 2016/8/3.
 */
public class FibonacciSupplier implements Supplier<Long> {

    long a = 0;
    long b = 1;

    @Override
    public Long get() {
        long x = a + b;
        a = b;
        b = x;
        return a;
    }
}
