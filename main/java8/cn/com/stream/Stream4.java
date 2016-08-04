package cn.com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2016/8/3.
 */
public class Stream4 {

    public static void main(String[] args) {
        List<String> friends = Arrays.asList("Xiaxuan", "Bingwen");
        final List<String> startWithN = friends.stream()
                .filter(name -> name.startsWith("X"))
                .collect(Collectors.toList());
        startWithN.forEach(System.out::println);
    }

}
