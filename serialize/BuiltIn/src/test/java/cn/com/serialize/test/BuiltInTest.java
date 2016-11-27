package cn.com.serialize.test;

import cn.com.builtin.bean.CustomItemDto;
import cn.com.builtin.bean.User;
import cn.com.builtin.serialize.NativeSerializeTools;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaxuan on 16/11/24.
 */
public class BuiltInTest {

    private User user = new User(100, "Nick Huang");
    private String filePath = "/Users/xiaxuan/user.txt";

    @Test
    public void c1() throws FileNotFoundException, IOException {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            user = new User(i, "Nick Huang" + i);
            list.add(user);
        }
        long time = System.currentTimeMillis();
        NativeSerializeTools.write(filePath, list);
        System.out.println(System.currentTimeMillis() - time);
    }

    @Test
    public void testSame() throws IOException {
        List<CustomItemDto> customItemDtos = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            CustomItemDto val = new CustomItemDto();
            val.setId(Long.parseLong(String.valueOf(i)));
            val.setItemCode("");
            val.setItemDespositPrice(32.45);
            val.setItemMemo(null);
            val.setItemName("张金");
            val.setItemPrice(89.02);
            val.setSort(10);
            customItemDtos.add(val);
        }
        long time = System.currentTimeMillis();
        NativeSerializeTools.write(filePath, customItemDtos);
        long end = System.currentTimeMillis();
        System.out.println(end - time);
    }

    @Test
    public void c2() throws FileNotFoundException, IOException, ClassNotFoundException {
        Object o = NativeSerializeTools.read(filePath);

        System.out.println(o);
        Assert.assertTrue(user.equals(o));
    }
}
