package cn.com.callback;

/**
 * Created by Administrator on 2016/6/13.
 */
public class CallbackExample {

    public static void main(String[] args) {
        FooBar fooBar = new FooBar();
        fooBar.setCallback(new ICallback() {
            public void postExec() {
                System.out.println("��CallbackExample����ʵ�ֵ����ܱ�CallbackExample�Ķ�����ã����Ǳ�FooBar�Ķ������");
            }
        });
    }

}

interface ICallback {
    //��Ҫ�ص��ķ���
    public void postExec();
}

class FooBar {
    private ICallback callback;

    public void setCallback(ICallback callback) {
        this.callback = callback;
        doSth();
    }

    public void doSth() {
        callback.postExec();
    }
}
