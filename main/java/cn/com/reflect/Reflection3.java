package cn.com.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by xiaxuan on 16/8/5.
 */
public class Reflection3 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Person.class.getMethod("getUsername", null);
        Person p = new Person("xiaxuan");
        Object returnValue = method.invoke(p, null);
        System.out.println(returnValue);
    }
}
