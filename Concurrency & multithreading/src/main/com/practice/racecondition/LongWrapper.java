package main.com.practice.racecondition;

/**
 * Created by Amruta on 4/21/2017.
 */
public class LongWrapper {

    Object key = new Object();
    private long l;

    public LongWrapper(long l) {
        this.l = l;
    }

    public long getValue() {
        return l;
    }

    /*
        public long increamentValue(){
            return l = l + 1;
    }*/
    public long incrementValue() {
        synchronized (key) {
            return l = l + 1;
        }
    }
}
