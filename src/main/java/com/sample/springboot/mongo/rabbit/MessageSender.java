package com.sample.springboot.mongo.rabbit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.springboot.mongo.model.Caterer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author syedbilalraza
 * @date 23/05/2021
 */
@Component
@Slf4j
public class MessageSender {
   @Autowired
    private  RabbitTemplate rabbitTemplate;


    static final String topicExchangeName = "spring-boot-exchange";
    public void sendMessageToRabbit(Caterer caterer) {
        ObjectMapper objectMapper=new ObjectMapper();
        String objectString= null;
        try {
            objectString = objectMapper.writeValueAsString(caterer);
            rabbitTemplate.convertAndSend(topicExchangeName, "caterer", objectString);
            log.info("Send message successfull message= "+ objectString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
