package com.imooc.girl.core.multithreading;

import java.util.concurrent.Callable;

/**
 * Created by hmh on 2017/8/15.
 */
public class CallableDemo implements Callable<Integer> {
    private int sum;

    @Override
    public synchronized Integer call() throws Exception {
        long startTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "开始计算" + sum);
        Thread.sleep(200);

//        for (int i = 0; i < 1000; i++) {
//         (this) {
            sum += 1;
//        }
//        }

        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "计算结束：" + sum + ", 花费时间：" + (endTime - startTime) + "ms");
        return sum;
    }
}
