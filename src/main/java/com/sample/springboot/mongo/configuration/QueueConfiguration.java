package com.sample.springboot.mongo.configuration;

import com.sample.springboot.mongo.rabbit.Receiver;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;

/**
 * @author syedbilalraza
 * @date 23/05/2021
 */
public class QueueConfiguration {
    static final String topicExchangeName = "spring-boot-exchange";

    static final String queueName = "spring-test";

    @Bean
    public Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(topicExchangeName);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("caterer");
    }

    @Bean
    public MessageListenerContainer container(ConnectionFactory connectionFactory,
                                              MessageListenerAdapter listenerAdapter, Receiver receiver) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(receiver);
        container.setConcurrentConsumers(2);
        container.initialize();
        return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

}
