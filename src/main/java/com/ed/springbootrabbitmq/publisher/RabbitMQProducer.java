package com.ed.springbootrabbitmq.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

    @Value("${sp.rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${sp.rabbitmq.routing.name}")
    private String routingName;


    private RabbitTemplate rabbitTemplate;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

     private static final Logger LOGGER= LoggerFactory.getLogger(RabbitMQProducer.class);
    public void sendMessage(String message){
      LOGGER.info(String.format("Message sent: %s",message));
       rabbitTemplate.convertAndSend(exchangeName, routingName, message);
    }

}
