package main.com.practice.mulithreading;

/**
 * Created by Amruta on 4/21/2017.
 */
public class FirstMultithreading {

    public static void main(String[] args){
        Runnable runnable = () -> {
            System.out.println("I am in running thread "+ Thread.currentThread().getName());
        };

        Thread t = new Thread(runnable);
        t.setName("My thread");
        //t.run();   I am in running thread main
        t.start();   // Start the new thread and then run it
    }
}
