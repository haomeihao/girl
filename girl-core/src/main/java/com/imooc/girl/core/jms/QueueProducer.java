package com.imooc.girl.core.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ScheduledMessage;

import javax.jms.*;

/**
 * Created by hmh on 2017/8/22.
 */
public class QueueProducer {

    private static final String url = "tcp://127.0.0.1:61616";

    private static final String queueName = "queue-test";

    public static void main(String[] args) throws JMSException {

        // 1 创建ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

        // 2 创建Connection
        Connection connection = connectionFactory.createConnection();

        // 3 启动连接
        connection.start();

        // 4 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 5 创建一个目标 Queue实现Destination接口
        Destination destination = session.createQueue(queueName);

        // 6 创建一个生产者
        MessageProducer producer = session.createProducer(destination);

        // 发送消息
        sendMessage(session, producer);

        // 9 关闭连接
        connection.close();
    }

    protected static void sendMessage(Session session, MessageProducer producer) throws JMSException {
        for (int i = 0; i < 100; i++) {
            // 4 创建消息
            TextMessage message = session.createTextMessage("test" + i);

            //设置延迟
            //Use a Cron entry to set the schedule
            message.setStringProperty(ScheduledMessage.AMQ_SCHEDULED_CRON, "1 * * * *");
            //The time in milliseconds that a message will wait before being scheduled to be delivered by the broker
            message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, 1000);
            //The time in milliseconds to wait after the start time to wait before scheduling the message again
            message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_PERIOD, 1000);
            //The number of times to repeat scheduling a message for delivery
            message.setIntProperty(ScheduledMessage.AMQ_SCHEDULED_REPEAT, 3);

            // 5 发送消息
            producer.send(message);
            System.out.println("发送消息" + message.getText());
        }
    }

}
