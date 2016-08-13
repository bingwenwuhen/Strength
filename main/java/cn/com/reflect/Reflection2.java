package cn.com.reflect;

import java.lang.reflect.Field;

/**
 * Created by xiaxuan on 16/8/5.
 */
public class Reflection2 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class aClss = Person.class;
        Field field = aClss.getField("username");
        Person person = new Person("xiaxuan");
        Object value = field.get(person);
        field.set(person, value);
        System.out.println(value);
    }

}
