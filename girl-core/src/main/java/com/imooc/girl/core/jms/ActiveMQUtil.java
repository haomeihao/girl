package com.imooc.girl.core.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * ActiveMQ工具类
 *
 * @author hmh
 * @since 2018-05-07
 */
public class ActiveMQUtil {

    private static final String URL = "tcp://127.0.0.1:61616";
    private static final String QUEUE_NAME = "queue-test";

    public static Connection getConnection() throws JMSException {
        // 1 创建ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        // 2 创建Connection
        Connection connection = connectionFactory.createConnection();
        // 3 启动连接
        connection.start();
        return connection;
    }

    public static Session createSession() throws JMSException {
        Connection connection = getConnection();
        // 4 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        return session;
    }

    private static Destination getDestination() throws JMSException {
        Session session = createSession();
        // 5 创建一个目标 Queue实现Destination接口
        Destination destination =  session.createQueue(QUEUE_NAME);
        return destination;
    }

    public static MessageProducer createProducer(Session session) throws JMSException {
        Destination destination = getDestination();
        // 6 创建一个生产者
        MessageProducer producer = session.createProducer(destination);

        return producer;
    }

    public static MessageConsumer createConsumer(Session session) throws JMSException {
        Destination destination = getDestination();
        // 6 创建一个消费者
        MessageConsumer consumer = session.createConsumer(destination);

        return consumer;
    }

    public static void closeConnection(Connection connection) throws JMSException {
        // 9 关闭连接
        connection.close();
    }

}
