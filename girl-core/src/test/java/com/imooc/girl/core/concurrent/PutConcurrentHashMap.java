package com.imooc.girl.core.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hmh on 2017/8/15.
 */
public class PutConcurrentHashMap implements Runnable {
    final static int ThreadSize = 2500;
    final static int elSize = 2500;
    int threadNum;

    public PutConcurrentHashMap(int threadNum) {
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        Map<String, String> concurrentHashMap = new ConcurrentHashMap();
        for (int i = 0; i < elSize; i++) {
            concurrentHashMap.put(i + "" + threadNum, i + "" + threadNum);
        }
    }

    public static void main(String[] args) {
        //启用线程池
        ExecutorService exec = Executors.newFixedThreadPool(ThreadSize);

        long startTime = System.currentTimeMillis();
        for (int index = 0; index <= ThreadSize; index++) {
            exec.execute(new PutConcurrentHashMap(index));
        }
        long endTime = System.currentTimeMillis();
        exec.shutdown();
        System.out.println("消耗时间：" + (endTime - startTime) + "ms");
    }
}
