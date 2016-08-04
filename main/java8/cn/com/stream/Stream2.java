package cn.com.stream;

import java.util.stream.Stream;

/**
 * Created by Administrator on 2016/8/2.
 */
public class Stream2 {

    public static void main(String[] args) {
        Stream<Long> natual = Stream.generate(new NaturalSupplier());
        natual.map((x)->{
            return x * x;
        }).limit(10).forEach(System.out::println);
    }

}
