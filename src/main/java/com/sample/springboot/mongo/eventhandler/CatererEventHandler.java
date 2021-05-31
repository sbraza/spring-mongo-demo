package com.sample.springboot.mongo.eventhandler;

import com.sample.springboot.mongo.model.Caterer;
import com.sample.springboot.mongo.rabbit.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

/**
 * @author syedbilalraza
 * @date 21/05/2021
 */
@Component
@RepositoryEventHandler
public class CatererEventHandler  {

    @Autowired
    private MessageSender messageSender;

    @HandleBeforeCreate
    public void handleBookCatererCreate(Caterer caterer){
        // code for before create book event
        messageSender.sendMessageToRabbit(caterer);
        System.out.println("Caterer creation in progress");
    }

}
