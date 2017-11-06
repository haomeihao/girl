package com.imooc.girl.web.thread;

/**
 * Created by hmh on 2017/10/10.
 */
public class CounterThread implements Runnable {
    protected Counter counter = null;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print(Thread.currentThread().getName() + "\t");
            counter.add(i);
            System.out.print("\n");
        }
    }
}
