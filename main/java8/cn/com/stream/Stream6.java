package cn.com.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/8/3.
 */
public class Stream6 {

    public static void main(String[] args) {
        List<String> friends = Arrays.asList("Xiaxuan", "Bingwen");
        System.out.println("Total number of characters is all names: " +
        friends.stream().mapToInt(name -> name.length())
                        .sum());

        System.out.println(String.join(",", friends));
    }

}
