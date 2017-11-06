package com.imooc.girl.core.multithreading;

/**
 * Created by hmh on 2017/8/15.
 */
public class MultiProducerConsumer {
    public static void main(String[] args) {
        MultiKaoYaResource r = new MultiKaoYaResource();
        MultiProducer pro = new MultiProducer(r);
        MultiConsumer con = new MultiConsumer(r);
        //生产者线程
        Thread t0 = new Thread(pro);
        Thread t1 = new Thread(pro);
        //消费者线程
        Thread t2 = new Thread(con);
        Thread t3 = new Thread(con);
        //启动线程
        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }
}

/**
 * 生产者线程
 */
class MultiProducer implements Runnable {
    private MultiKaoYaResource r;

    MultiProducer(MultiKaoYaResource r) {
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
class MultiConsumer implements Runnable {
    private MultiKaoYaResource r;

    MultiConsumer(MultiKaoYaResource r) {
        this.r = r;
    }

    public void run() {
        while (true) {
            r.consume();
        }
    }
}