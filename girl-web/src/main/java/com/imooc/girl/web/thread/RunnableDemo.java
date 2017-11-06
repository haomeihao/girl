package com.imooc.girl.web.thread;

/**
 * Created by hmh on 2017/10/10.
 */
public class RunnableDemo {

    private int count = 0;

    private static int count2 = 0;

    public synchronized void add(int value) {
        this.count += value;
    }

    public static synchronized void add2(int value) {
        count2 += value;
    }

    public void add3(int value) {
        synchronized (this) {
            this.count += value;
        }
    }

    public static void add4(int value) {
        synchronized (RunnableDemo.class) {
            count2 += value;
        }
    }

}
