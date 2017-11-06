package com.imooc.girl.core.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by hmh on 2017/8/15.
 */
public class CallableTest {
    public static void main(String[] args) {
        // 创建线程池
        ExecutorService exec = Executors.newSingleThreadExecutor();
        // 创建Callable对象任务
        CallableDemo calTask = new CallableDemo();
        // 提交任务并获取执行结果
        Future<Integer> future = exec.submit(calTask);
        // 关闭线程池
        exec.shutdown();

        try {
            Thread.sleep(2000);
            System.out.println("主线程在执行其他任务");
            if (future.get() != null) {
                System.out.println("future.get()-->" + future.get());
            } else {
                System.out.println("future.get()未获取到结果");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完成");

    }
}
