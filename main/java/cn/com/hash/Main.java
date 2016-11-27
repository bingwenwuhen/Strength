package cn.com.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaxuan on 16/9/22.
 */
public class Main {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        String Aa = "Aa";
        String BB = "BB";
        map.put(Aa, "1");
        map.put(BB, 2);
        System.out.println(map.get(Aa));
        System.out.println(map.get(BB));
        System.out.println(Aa.hashCode() == BB.hashCode());
    }
}
