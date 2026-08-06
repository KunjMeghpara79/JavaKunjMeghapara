public class Conquerency {
    static Count c = new Count();
    static class t1 implements Runnable{
        @Override
        public void run() {
            c.increament();
            c.decreament();
        }
    }
   static class t2 implements Runnable{
        @Override
        public void run() {
            c.decreament();
            c.increament();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new t1());
        Thread t2 = new Thread(new t2());
        t1.start();
        t2.start();

        //t1.join means the main thread will be in waiting state until the t1 completes its execution and go in dead state. same for t2
        // if we do not use these joins methods then both threads are free to be terminated anytime and
        // that will lead to race condition even if we have synchronized it.
        t1.join();
        t2.join();

        System.out.println(c.getCount());
    }
}
