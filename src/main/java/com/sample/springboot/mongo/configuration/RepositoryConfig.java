package com.sample.springboot.mongo.configuration;

import com.sample.springboot.mongo.model.Caterer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * @author syedbilalraza
 * @date 22/05/2021
 */
@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {



    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors){
        config.exposeIdsFor(Caterer.class);
    }

    /*@Override
    void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener v) {
        v.addValidator("beforeSave", new BeforeSaveValidator());
    }*/

}