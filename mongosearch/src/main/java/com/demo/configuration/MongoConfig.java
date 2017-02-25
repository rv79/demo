package com.demo.configuration;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by Herve on 22/02/2017.
 */

//@Configuration
@SuppressWarnings("unused")
public class MongoConfig {

    public //@Bean
    MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(new MongoClient("localhost"),"testdb");
        return mongoTemplate;
    }
}
