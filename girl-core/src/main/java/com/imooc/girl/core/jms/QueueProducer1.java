package com.imooc.girl.core.jms;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

/**
 * Created by hmh on 2017/8/22.
 */
public class QueueProducer1 {

    public static void main(String[] args) throws JMSException {
        // 1 获取Connection
        Connection connection = ActiveMQUtil.getConnection();
        // 2 创建会话
        Session session = ActiveMQUtil.createSession();
        // 3 创建一个生产者
        MessageProducer producer = ActiveMQUtil.createProducer(session);

        // 4 发送消息
        QueueProducer.sendMessage(session, producer);

        // 5 关闭连接
        ActiveMQUtil.closeConnection(connection);
    }

}
