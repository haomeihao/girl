package com.imooc.girl.core.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hmh on 2017/8/15.
 */
public class PubHashMap implements Runnable {
    final static int ThreadSize = 2500;
    final static int elSize = 2500;
    int threadNum;

    public PubHashMap(int threadNum) {
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        Map<String, String> hashMap = new HashMap();
        for (int i = 0; i < elSize; i++) {
            hashMap.put(i + "" + threadNum, i + "" + threadNum);
        }
    }

    public static void main(String[] args) {
        //启用线程池
        ExecutorService exec = Executors.newFixedThreadPool(ThreadSize);

        long startTime = System.currentTimeMillis();
        for (int index = 0; index <= ThreadSize; index++) {
            exec.execute(new PubHashMap(index));
        }
        long endTime = System.currentTimeMillis();
        exec.shutdown();
        System.out.println("消耗时间：" + (endTime - startTime) + "ms");
    }
}
