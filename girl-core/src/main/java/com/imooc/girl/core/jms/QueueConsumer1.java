package com.imooc.girl.core.jms;

import javax.jms.*;

/**
 * Created by hmh on 2017/8/22.
 */
public class QueueConsumer1 {

    public static void main(String[] args) throws JMSException {
        // 1 获取Connection
        Connection connection = ActiveMQUtil.getConnection();
        // 2 创建会话
        Session session = ActiveMQUtil.createSession();
        // 3 创建一个消费者
        MessageConsumer consumer = ActiveMQUtil.createConsumer(session);

        // 4 创建监听器监听消息
        QueueConsumer.onListenMessage(consumer);

        // 5 关闭连接
        ActiveMQUtil.closeConnection(connection);
    }
}
