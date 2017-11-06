package com.imooc.girl.web.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hmh on 2017/10/10.
 */
public class Synchronizer {
    Lock lock = new ReentrantLock();

    public void doSynchronized() {
        this.lock.lock();

        this.lock.unlock();
    }

}
