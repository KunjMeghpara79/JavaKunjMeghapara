class count{
    private int c = 0;
    public synchronized void increament(){
        for(int i = 0;i<100000;i++) c++;
    }
    public synchronized void decreament(){
        for(int i = 0;i<100000;i++) c--;
    }
    public int getcount(){
        return c;
    }
}
public class Conquerency {
    static count c = new count();
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
