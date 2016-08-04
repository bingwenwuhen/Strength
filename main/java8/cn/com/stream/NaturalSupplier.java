package cn.com.stream;

import java.util.function.Supplier;

/**
 * Created by Administrator on 2016/8/2.
 */
public class NaturalSupplier implements Supplier<Long> {

    Long value = 0L;

    @Override
    public Long get() {
        this.value ++;
        return value;
    }
}
