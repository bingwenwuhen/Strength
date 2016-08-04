package cn.com.stream;

import java.util.stream.Stream;

/**
 * Created by Administrator on 2016/8/3.
 */
public class FibonacciStream {

    public static void main(String[] args) {
        Stream<Long> fibonacci = Stream.generate(new FibonacciSupplier());
        fibonacci.limit(10).forEach(System.out::println);
    }

}
