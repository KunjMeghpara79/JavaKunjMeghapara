import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConquerencyUsingExecutorService {

    static Count c = new Count();

    static class T1 implements Runnable {
        @Override
        public void run() {
            c.increament();
        }
    }

    static class T2 implements Runnable {
        @Override
        public void run() {
            c.decreament();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(new T1());
        executor.submit(new T2());
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println(c.getcount());
    }
}