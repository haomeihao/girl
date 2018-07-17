package com.imooc.girl.core.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by hmh on 2017/8/22.
 */
public class QueueConsumer {

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

        // 6 创建一个消费者
        MessageConsumer consumer = session.createConsumer(destination);

        // 7 创建监听器监听消息
        onListenMessage(consumer);

        // 8 关闭连接
//        connection.close();
    }

    //创建监听器监听消息
    protected static void onListenMessage(MessageConsumer consumer) throws JMSException {
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("接收消息" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
