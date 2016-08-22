package cn.com.heap;

/**
 * VM Args: -Xss2M (这时候不妨设置更大些)
 * Created by xiaxuan on 16/8/22.
 */
public class JAVAVMSStackOOM {

    private void dontStop() {
        while (true) {}
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JAVAVMSStackOOM oom = new JAVAVMSStackOOM();
        oom.stackLeakByThread();
    }
}
