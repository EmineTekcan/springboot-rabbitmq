package com.ed.springbootrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${sp.rabbitmq.queue.name}")
    private String queueName;
    @Value("${sp.rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${sp.rabbitmq.routing.name}")
    private String routingName;
    @Bean
    public Queue queue(){
        return new Queue(queueName);
    }
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue())
                .to(topicExchange())
                .with(routingName);
    }
}
