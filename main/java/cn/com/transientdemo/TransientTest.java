package cn.com.transientdemo;

import java.io.*;

/**
 * Created by xiaxuan on 16/9/24.
 */
public class TransientTest {

    public static void main(String[] args) {
        User user = new User();
        user.setUsername("xiaxuan");
        user.setPassword("123456");
        System.out.println(user);
        System.out.println("=================");
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("./user.txt"));
            os.writeObject(user);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("./user.txt"));
            user = (User) is.readObject();
            is.close();
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
