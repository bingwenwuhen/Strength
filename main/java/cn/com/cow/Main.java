package cn.com.cow;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by xiaxuan on 16/8/13.
 */
public class Main {

    public static void main(String[] args) {
        //容器的使用方式和list的使用方式相同
        //多个线程的写操作，会有重入锁来保证写操作不会发生数据不一致的问题
        CopyOnWriteArrayList<String> cowl = new CopyOnWriteArrayList<>();
        CopyOnWriteArraySet<String> cwas = new CopyOnWriteArraySet<>();
        cowl.add("123");
    }

}
