package cn.com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by xiaxuan on 16/8/5.
 */
public class Reflection1 {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Method[] methods = Reflection1.class.getMethods();
        for (Method method: methods) {
            System.out.println("method = " + method.getName());
            Constructor constructor = Person.class.getConstructor(String.class);
            Person person = (Person) constructor.newInstance("xiaxuan");
            System.out.println(person.getUsername());

        }
    }

}
