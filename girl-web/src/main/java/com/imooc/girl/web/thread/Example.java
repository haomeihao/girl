package com.imooc.girl.web.thread;

/**
 * Created by hmh on 2017/10/10.
 */
public class Example {
    public static void main(String[] args) {
        Counter counter = new Counter();
        CounterThread thread = new CounterThread(counter);
        new Thread(thread).start();
        new Thread(thread).start();
    }
}
