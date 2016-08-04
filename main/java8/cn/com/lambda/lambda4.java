package cn.com.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/2.
 */
public class lambda4 {

    public static void main(String[] args) {
        List<Long> ids = new ArrayList<>();
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "xiaxuan"));
        users.add(new User(2L, "bingwen"));
        users.forEach(
                (item) -> ids.add(item.getId())
        );
        System.out.println(ids);
    }
}
