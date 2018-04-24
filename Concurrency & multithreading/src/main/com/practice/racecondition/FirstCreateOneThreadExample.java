package main.com.practice.racecondition;

/**
 * Created by Amruta on 4/21/2017.
 */
public class FirstCreateOneThreadExample {

    public static void main(String[] a) throws InterruptedException {

        LongWrapper l = new LongWrapper(0L);
        Runnable runnable = () -> {
            for (int i = 0; i < 1_000; i++)
                l.incrementValue();
        };

        // one plain thread is running
        Thread t = new Thread(runnable);
        t.start();

        t.join();
        System.out.println(l.getValue());
    }
}
