package com.imooc.girl.core.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 加锁 替代 synchronized
 * Created by hmh on 2017/10/17.
 */
public class LockTest {
    public static void main(String[] args) {
        final Output1 output = new Output1();
        new Thread() {
            @Override
            public void run() {
                output.output("zhangsan");
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                output.output("lisi");
            }
        }.start();
    }


}

class Output1 {
    private Lock lock = new ReentrantLock();

    public void output(String name) {
        lock.lock();
        try {
            for (int i = 0; i < name.length(); i++) {
                System.out.print(name.charAt(i));
            }
        } finally {
            lock.unlock();
        }

    }
}