import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
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
    // Throws InterruptedException if the Main Thread itself is forcefully
    // signaled/interrupted by another thread while waiting here. This acts
    // as an emergency wake-up call, aborting the timer immediately.


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(new T1());
        executor.submit(new T2());
        executor.shutdown();
        /*
        The thread pool is now legally locked from accepting new tasks.
        If you try to call executor.submit() after this line, Java will throw a RejectedExecutionException
         */
        executor.awaitTermination(1, TimeUnit.MINUTES);
        // this method works same as join in the traditional threads but here we have to give waiting time and time unit as an arguments
        // As the executorService is a modern feature of java this method does not support no waiting time
        // argument inorder to avoid infinite loops or deadlock

        System.out.println(c.getCount());

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        // if we want to invoke all 100 threads at same time then we can use this method here is callable is a functional interface with generics type
        List<Callable<Void>> list = new ArrayList<>();
        for(int i = 0;i<100;i++){
            list.add(() -> {
                c.increament();
                c.decreament();
                return null;
            });
        }
        executorService.invokeAll(list);
        System.out.println(c.getCount());
    }
}