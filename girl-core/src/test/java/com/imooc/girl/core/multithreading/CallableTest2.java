package com.imooc.girl.core.multithreading;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by hmh on 2017/8/15.
 */
public class CallableTest2 {
    public static void main(String[] args) {
        // 创建线程池
//        ExecutorService exec = Executors.newSingleThreadExecutor();
//        ExecutorService exec = Executors.newCachedThreadPool();
        ExecutorService exec = Executors.newFixedThreadPool(10);
        // 创建Callable对象任务
        CallableDemo calTask = new CallableDemo();

        List<FutureTask> list = new LinkedList();

        // 执行任务
        for (int i = 0; i < 10; i++) {
            // 创建FutureTask
            FutureTask<Integer> futureTask1 = new FutureTask(calTask);
            exec.submit(futureTask1);
            list.add(futureTask1);
        }
        // 关闭线程池
        exec.shutdown();

        try {
            Thread.sleep(2000);
            System.out.println("主线程执行其他任务");
            for (FutureTask futureTask : list) {
                int index = list.indexOf(futureTask);
                if (futureTask.get() != null) {
                    System.out.println("futureTask[" + index + "].get()-->" + futureTask.get());
                } else {
                    System.out.println("futureTask[" + index + "].get()未获取到结果");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完成");

//        Iterator iterator = sums.iterator();
//        while (iterator.hasNext()) {
//            Integer value = (Integer)iterator.next();
//            System.out.println(value);
//        }
    }
}
