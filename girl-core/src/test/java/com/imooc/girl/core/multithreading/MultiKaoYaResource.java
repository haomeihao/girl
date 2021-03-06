package com.imooc.girl.core.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hmh on 2017/8/15.
 */
public class MultiKaoYaResource {
    private String name;
    private int count = 1;//烤鸭的初始数量
    private boolean flag = false;//判断是否有需要线程等待的标志

    //创建一个锁对象
    private Lock resourceLock = new ReentrantLock();
    //创建条件对象
//    private Condition condition = resourceLock.newCondition();

    //通过已有的锁获取两组监视器，一组监视生产者，一组监视消费者。
    private Condition producerCon = resourceLock.newCondition();
    private Condition consumerCon = resourceLock.newCondition();

    /**
     * 生产烤鸭
     */
    public void product(String name) {
        resourceLock.lock();
        try {
            while (flag) {
                //此时有烤鸭，等待
                try {
//                this.wait();
//                    condition.await();
                    producerCon.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.name = name + count;//设置烤鸭的名称
            count++;
            System.out.println(Thread.currentThread().getName() + "...生产者..." + this.name);
            flag = true;//有烤鸭后改变标志
//        notifyAll();//通知消费线程可以消费了
//            condition.signalAll();
            consumerCon.signal();
        } finally {
            resourceLock.unlock();
        }
    }

    /**
     * 消费烤鸭
     */
    public void consume() {
        resourceLock.lock();
        try {
            while (!flag) {//如果没有烤鸭就等待
                try {
//                    this.wait();
//                    condition.await();
                    consumerCon.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "...消费者........" + this.name);//消费烤鸭1
            flag = false;
//            notifyAll();//通知生产者生产烤鸭
//            condition.signalAll();
            producerCon.signal();
        } finally {
            resourceLock.unlock();
        }

    }
}
