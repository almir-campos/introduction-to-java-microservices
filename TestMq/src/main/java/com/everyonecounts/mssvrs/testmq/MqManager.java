/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.everyonecounts.mssvrs.testmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acampos
 */
public class MqManager
{

    private static Connection connection = null;
    private static Channel channel = null;
    private static final List<String> queueNames = new ArrayList();

    private static Connection getConnection()
    {
        if (connection == null)
        {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setUsername("root");
            factory.setPassword("root");
            factory.setVirtualHost("NJSVRS-Main");
            factory.setHost("10.16.1.234");
            factory.setPort(5672);
            try
            {
                connection = factory.newConnection();
            }
            catch (IOException | TimeoutException ex)
            {
                Logger.getLogger(MqManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }

    private static Channel getChannel()
    {
        if (channel == null)
        {
            try
            {
                channel = getConnection().createChannel();
            }
            catch (IOException ex)
            {
                Logger.getLogger(MqManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return channel;
    }

    private static String getQueueName(String queueName)
    {
        if (!queueNames.contains(queueName))
        {
            try
            {
                getChannel().queueDeclare(queueName, false, false, false, null);
            }
            catch (IOException ex)
            {
                Logger.getLogger(MqManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            queueNames.add(queueName);
        }
        return queueName;
    }

    public static void sendStringMsg(String queueName, String msg)
    {
        byte[] messageBodyBytes = msg.getBytes();
        try
        {
            getChannel().basicPublish("", getQueueName(queueName), null, messageBodyBytes);
        }
        catch (IOException ex)
        {
            Logger.getLogger(MqManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
