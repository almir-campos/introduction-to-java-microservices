package com.everyonecounts.mssvrs.testmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by acampos on 12/28/16.
 */
public class TestMq
{

    public static void main(String[] args)
    {
//        ConnectionFactory connectionFactory
//                = new CachingConnectionFactory();
//        AmqpAdmin admin = new RabbitAdmin(connectionFactory);
//        Queue queue = new Queue("testQ1");
//        admin.declareQueue( queue );
//        AmqpTemplate template = new RabbitTemplate(connectionFactory);
//        template.convertAndSend("testQ1", "Did it work??????");

//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setUsername("root");
//        factory.setPassword("root");
//        factory.setVirtualHost("NJSVRS-Main");
//        factory.setHost("10.16.1.234");
//        factory.setPort(5672);
//        Connection conn = factory.newConnection();
//
//        Channel channel = conn.createChannel();
//        channel.queueDeclare("testQ", false, false, false, null);
//        byte[] messageBodyBytes = "ABCDEF".getBytes();
//        channel.basicPublish("", "testQ", null, messageBodyBytes);

        
//        Channel channel = MqManager.createQueue("testQ");
//        byte[] messageBodyBytes = "12345".getBytes();
//        channel.basicPublish("", "testQ", null, messageBodyBytes);
        int i = 0;
        while( true )
        {
            try
            {
                Thread.sleep(5000);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            MqManager.sendStringMsg("testQ", String.valueOf( i++ ) );
            MqManager.sendStringMsg("testQ1", "Test " + i );
        }
        
//        GetResponse getResponse = channel.basicGet("testQ", true);
//        System.out.println( "GET RESPONSE: " + new String( getResponse.getBody() ) );



//        boolean autoAck = false;
//        channel.basicConsume("testQ", autoAck, "myConsumerTag",
//                new DefaultConsumer(channel)
//        {
//            @Override
//            public void handleDelivery(String consumerTag,
//                                       Envelope envelope,
//                                       AMQP.BasicProperties properties,
//                                       byte[] body)
//                    throws IOException
//            {
//                String routingKey = envelope.getRoutingKey();
//                String contentType = properties.getContentType();
//                long deliveryTag = envelope.getDeliveryTag();
//                GetResponse getResponse = channel.basicGet("testQ", true);
//                System.out.println("GET RESPONSE:: " + new String( body ));
//                channel.basicAck(deliveryTag, false);
//            }
//        });

    }

}
