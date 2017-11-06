package com.imooc.girl.core.multithreading;

/**
 * Created by hmh on 2017/8/15.
 */
public class SingleProducerConsumer {
    public static void main(String[] args) {
        SingleKaoYaResource r = new SingleKaoYaResource();
        Producer pro = new Producer(r);
        Consumer con = new Consumer(r);
        //生产者线程
        Thread t0 = new Thread(pro);
        //消费者线程
        Thread t2 = new Thread(con);
        //启动线程
        t0.start();
        t2.start();
    }

}

/**
 * 生产者线程
 */
class Producer implements Runnable {
    private SingleKaoYaResource r;

    Producer(SingleKaoYaResource r) {
        this.r = r;
    }

    public void run() {
        while (true) {
            r.product("北京烤鸭");
        }
    }
}

/**
 * 消费者线程
 */
class Consumer implements Runnable {
    private SingleKaoYaResource r;

    Consumer(SingleKaoYaResource r) {
        this.r = r;
    }

    public void run() {
        while (true) {
            r.consume();
        }
    }
}
