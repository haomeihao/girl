package com.imooc.girl.core.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by hmh on 2017/8/11.
 */
public class CallableThreadTest implements Callable<Integer> {
    public static void main(String[] args) {
        CallableThreadTest ctt = new CallableThreadTest();
        FutureTask<Integer> ft = new FutureTask<>(ctt);

        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "的循环变量i的值" + i);
            if (i > 0 && i % 5 == 0) {
                new Thread(ft, "有返回值的线程" + i + "：").start();
            }
        }

        try {
            System.out.println("子线程的返回值：" + ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "" + i);
        }
        return i;
    }
}
