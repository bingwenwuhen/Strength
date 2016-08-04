package cn.com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Administrator on 2016/8/3.
 */
public class Stream5 {
    public static void main(String[] args) {
        List<String> friends = Arrays.asList("Xiaxuan", "Bingwen");
        final Predicate<String> startWithN = name -> name.startsWith("X");
        final long countFriendsStartN = friends.stream().filter(startWithN).count();
        System.out.println(countFriendsStartN);
    }
}
