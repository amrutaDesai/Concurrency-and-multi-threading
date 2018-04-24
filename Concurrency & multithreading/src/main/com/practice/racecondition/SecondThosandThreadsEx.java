package main.com.practice.racecondition;

/**
 * Created by Amruta on 4/21/2017.
 */
public class SecondThosandThreadsEx {

    public static void main(String[] args) throws InterruptedException {
        LongWrapper l = new LongWrapper(0L);

        Runnable runnable = () -> {
            for (int i = 0; i < 1_000; i++)
                l.incrementValue();
        };

        // Run the thousand threads for accessing same variable end up with race condition
        Thread[] threads = new Thread[1_000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(runnable);
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        // All thread accessing same variable, read and write operation is happening on the same variable by different threads
        // The value is not thread safe
        // so it results in 998699 or 998674 or 9986981... instead of 1000000
        // to avoid this synchronized block should be added at the read and write operation
        // i.e. increamentValue() of LongWrapper class now the result is 1000000
        System.out.println("value = "+ l.getValue());
    }


}
