package cn.com.reflect;

import java.lang.reflect.Method;

/**
 * Created by xiaxuan on 16/8/5.
 */
public class Reflection4 {
    public static void main(String[] args) {
        Class clazz = Person.class;
        Method[] methods = clazz.getMethods();
        for (Method method: methods) {
            if (isGetter(method)) System.out.println("getter: " + method);
            if (isSetter(method)) System.out.println("setter: " + method);
        }
    }

    public static boolean isGetter(Method method) {
        if (!method.getName().startsWith("get")) return false;
        if (method.getParameterTypes().length != 0) return false;
        if (void.class.equals(method.getReturnType())) return false;
        return true;
    }

    public static boolean isSetter(Method method) {
        if (!method.getName().startsWith("set")) return false;
        if (method.getParameterTypes().length != 1) return false;
        return true;
    }
}
