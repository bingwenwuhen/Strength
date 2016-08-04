package cn.com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/8/3.
 */
public class Stream3 {

    public static void main(String[] args) {
        List<String> friends = Arrays.asList("Xiaxuan", "Bingwen");
        friends.stream()
                .map(name->name.toLowerCase())
                .forEach(name->System.out.print(name + " "));
        friends.stream()
                .map(name -> name.length())
                .forEach(count -> System.out.println(count));
        //¼ò»¯Ð´·¨
        friends.stream()
                .map(String::toUpperCase)
                .forEach(name -> System.out.println(name));
    }

}
