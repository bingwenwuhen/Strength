package cn.com.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaxuan on 16/8/19.
 */
public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
