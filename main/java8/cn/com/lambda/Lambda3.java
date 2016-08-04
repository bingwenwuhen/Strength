package cn.com.lambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Administrator on 2016/8/2.
 */
public class Lambda3 {
    public static void main(String[] args) {
        String[] players = {
                "Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"
        };
        //1.1使用匿名内部类排序
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1.compareTo(o2));
            }
        });
        //1.2 使用lambda expression排序player
        Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
        Arrays.sort(players, sortByName);
        //也可以采用如下形式
        Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));
    }
}
