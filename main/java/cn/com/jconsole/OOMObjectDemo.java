package cn.com.jconsole;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaxuan on 16/8/30.
 * 内存占位符对象，一个OOMObject大约占64kb
 */
public class OOMObjectDemo {

    static class  OOMObject {
        public byte[] placeHolder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            //稍作延时，令监视曲线的变化更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}
