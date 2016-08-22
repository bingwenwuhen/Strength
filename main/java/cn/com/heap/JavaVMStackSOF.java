package cn.com.heap;

/**
 * Created by xiaxuan on 16/8/22.
 */
public class JavaVMStackSOF {

    private static int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Exception e) {
            System.out.println("stack length " + stackLength);
            throw e;
        }
    }
}
