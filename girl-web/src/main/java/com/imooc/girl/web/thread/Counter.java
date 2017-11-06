package com.imooc.girl.web.thread;

/**
 * Created by hmh on 2017/10/10.
 */
public class Counter {

    long count = 0;

    /*public synchronized void add(long value) {
        this.count += value;
        System.out.print(this.count);
    }*/

    public void add(long value) {
        synchronized (this) {
            this.count += value;
        }
        System.out.print(this.count);
    }
}
