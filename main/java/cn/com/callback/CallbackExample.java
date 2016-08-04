package cn.com.callback;

/**
 * Created by Administrator on 2016/6/13.
 */
public class CallbackExample {

    public static void main(String[] args) {
        FooBar fooBar = new FooBar();
        fooBar.setCallback(new ICallback() {
            public void postExec() {
                System.out.println("在CallbackExample类中实现但不能被CallbackExample的对象调用，而是被FooBar的对象调用");
            }
        });
    }

}

interface ICallback {
    //需要回调的方法
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
