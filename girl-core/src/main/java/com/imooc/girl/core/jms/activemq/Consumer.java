package com.imooc.girl.core.jms.activemq;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by hmh on 2017/8/22.
 */
@Component
public class Consumer implements CommandLineRunner{

    @Override
    public void run(String... args) throws Exception {
        System.out.println(args);
    }

    @JmsListener(destination = "sample-queue")
    public void receiveQueue(String text) {
        System.out.println("接收消息："+text);
    }

    @JmsListener(destination = "sample-topic")
    public void receiveTopic(String text) {
        System.out.println("接收消息："+text);
    }
}
