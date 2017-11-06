package com.imooc.girl.core.jms.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * Created by hmh on 2017/8/22.
 */
@SpringBootApplication
@EnableJms
public class SampleActiveMQApplication {

    private static final String brokerURL = "tcp://127.0.0.1:61616";

    @Bean
    public SingleConnectionFactory getConnectionFactory() {
        ConnectionFactory target = new ActiveMQConnectionFactory(brokerURL);
        SingleConnectionFactory connectionFactory = new SingleConnectionFactory(target);
        return connectionFactory;
    }

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("sample-queue");
    }

    @Bean
    public Topic topic() {
        return new ActiveMQTopic("sample-topic");
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate(getConnectionFactory());
        return jmsTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleActiveMQApplication.class, args);
    }
}
