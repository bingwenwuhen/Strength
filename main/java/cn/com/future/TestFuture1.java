package cn.com.future;

import com.google.common.util.concurrent.*;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by xiaxuan on 16/9/28.
 */
public class TestFuture1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

        ListenableFuture future1 = service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(1000);
                System.out.println("call future 1");
                return 1;
            }
        });

        ListenableFuture future2 = service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(1000);
                System.out.println("call future 2");
                return 2;
            }
        });

        final ListenableFuture allFutures = Futures.allAsList(future1, future2);
        final ListenableFuture transform = Futures.transform(allFutures, new AsyncFunction<List<Integer>, Boolean>() {

            @Override
            public ListenableFuture apply(List<Integer> integers) throws Exception {
                return Futures.immediateFuture(String.format("success future:%d", integers.size()));
            }
        });

        Futures.addCallback(transform, new FutureCallback<Object>() {
            @Override
            public void onSuccess(Object o) {
                System.out.println(o.getClass());
                System.out.printf("success with: %s%n", o);
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.printf("onFailure%s%n", throwable.getMessage());
            }
        });
        System.out.println(transform.get());
    }
}
