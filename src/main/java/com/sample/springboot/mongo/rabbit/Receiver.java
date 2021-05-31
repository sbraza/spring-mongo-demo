package com.sample.springboot.mongo.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;


/**
 * @author syedbilalraza
 * @date 23/05/2021
 */
@Slf4j
@Service
public class Receiver implements MessageListener {

    private CountDownLatch latch = new CountDownLatch(1);


  /*  @RabbitListener(queues = "spring-test")
    public void receiveMessage(final Message message) {
        log.info("Received message as a generic AMQP 'Message' wrapper: {}", message.toString());
    }
*/
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    @Override
    public void onMessage(Message message) {
        log.info("Received message as a generic AMQP 'Message' wrapper: {}", message.toString());

    }
}

