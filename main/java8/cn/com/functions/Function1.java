package cn.com.functions;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/8/3.
 */
public class Function1 {

    public static void main(String[] args) {
        boolean found = false;
        List<String> cities = Arrays.asList("wuhan", "beijin", "tianjing");
        for (String city: cities) {
            if (city.equals("wuhan")) {
                found = true;
                break;
            }
        }
        System.out.println("Found wuhan?" + cities.contains("wuhan"));
    }

}
