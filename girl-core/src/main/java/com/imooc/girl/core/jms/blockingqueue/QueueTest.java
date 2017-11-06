package com.imooc.girl.core.jms.blockingqueue;

import java.util.concurrent.*;

/**
 * Created by hmh on 2017/11/3.
 *
 * @author hmh
 */
public class QueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = null;

        queue = new LinkedBlockingDeque(10);

        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(consumer);

        Thread.sleep(10*1000);
        producer1.stop();
        producer2.stop();
        producer3.stop();

        Thread.sleep(2000);

        service.shutdown();
    }
}
