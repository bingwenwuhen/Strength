package cn.com.callback;

/**
 * Created by Administrator on 2016/6/14.
 */
public class CallbackFetcherExample {

    public static void main(String[] args) {
        new Worker().doWork();
    }

}

interface FetchCallback {
    void onData(Data data);
    void onError(Throwable cause);
}

interface Fetcher {
    void fetchData(FetchCallback callback);
}

class Worker {
    Data data = new Data();
    public void doWork() {
        Fetcher fetcher = new Fetcher() {
            public void fetchData(FetchCallback callback) {
                System.out.println("start fetch data");
            }
        };
        fetcher.fetchData(new FetchCallback() {
            public void onData(Data data) {
                System.out.println("Data received: " + data);
            }

            public void onError(Throwable cause) {
                System.out.println("An error accour: " + cause.getMessage());
            }
        });
    }
}

class Data {}

