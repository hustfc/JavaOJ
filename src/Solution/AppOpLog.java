package Solution;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AppOpLog {
    private static ThreadPoolExecutor getNewThreadPoolExecutor() {
        int queueSize = 30;
        int keepalibe = 30;
        return new ThreadPoolExecutor(10, 50, keepalibe, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(queueSize),new CommonThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
    }
    private static ThreadPoolExecutor threadPoolExecutor = getNewThreadPoolExecutor();

    public static void main(String[] args) {
        for(int i = 0; i <= 10; i ++) {
            threadPoolExecutor.execute(() -> {
                System.out.println("111");
            });
        }
    }
}
