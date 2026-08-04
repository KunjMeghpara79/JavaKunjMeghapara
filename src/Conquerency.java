
public class Conquerency {
    static Count c = new Count();
    static class t1 implements Runnable{
        @Override
        public void run() {
            c.increament();
        }
    }
   static class t2 implements Runnable{
        @Override
        public void run() {
            c.decreament();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new t1());
        Thread t2 = new Thread(new t2());
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(c.getcount());
    }
}
