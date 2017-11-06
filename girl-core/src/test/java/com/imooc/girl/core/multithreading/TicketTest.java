package com.imooc.girl.core.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hmh on 2017/8/15.
 */
public class TicketTest {

    private static int sleepSeconds = 1127;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
//        ExecutorService exec = Executors.newCachedThreadPool();

        Ticket t = new Ticket();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            exec.execute(t);
        }

        for (int j = 1; j <= 4; j++) {
            try {
                Thread.sleep(sleepSeconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("=================" + j + "==============消耗时间：" + (endTime - startTime) + "ms ================" + j + "===============");
        }

        exec.shutdown();
    }
}
