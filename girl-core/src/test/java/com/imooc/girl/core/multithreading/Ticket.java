package com.imooc.girl.core.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hmh on 2017/8/15.
 */
public class Ticket implements Runnable {
    private int num = 2000;

    private Lock ticketLock = new ReentrantLock();

    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            ticketLock.lock(); //获取锁
//            synchronized (obj) {
            if (num > 0) {
                try {
                    long startTime = System.currentTimeMillis();
                    Thread.sleep(2);
                    long endTime = System.currentTimeMillis();
                    System.out.println(Thread.currentThread().getName() + "...sale..." + num-- + "..." + endTime + "..." + startTime + "..." + (endTime - startTime) + "ms");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    ticketLock.unlock(); //释放锁
                }
            }
//            }

        }
    }

}
