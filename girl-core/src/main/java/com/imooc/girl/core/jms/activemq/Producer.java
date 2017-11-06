package com.imooc.girl.core.jms.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * Created by hmh on 2017/8/22.
 */
@Component
public class Producer implements CommandLineRunner {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 100; i++) {
            send("Sample message " + i);
            System.out.println("发送消息：Sample message " + i);
        }
    }

    public void send(String msg) {
//        this.jmsMessagingTemplate.convertAndSend(this.topic, msg);
        this.jmsTemplate.convertAndSend(this.topic, msg);
    }
}
