package cn.com.reflect;

import java.lang.reflect.Method;

/**
 * Created by xiaxuan on 16/8/18.
 */
public class Reflection5 {

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Reflection5.class.getMethod("print");
        System.out.println(method.getAnnotations());
    }


    @Deprecated
    private void print() {
        System.out.println("hello world");
    }
}
