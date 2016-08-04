package cn.com.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/8/2.
 */
public class Main {

    public static void main(String[] args) {
        String[] apt = {
                "Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"
        };
        List<String> players = Arrays.asList(apt);
        //以前的循环方式
        for (String player: players) {
            System.out.println(player + ",");
        }
        System.out.println();
        //使用lambda表达式以及函数操作
        players.forEach(
                (player) -> System.out.println(player + ",")
        );
        System.out.println();
        //在java8中使用双冒号操作符
        players.forEach(System.out :: println);
    }

}
