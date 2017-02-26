package com.demo.service;

import com.demo.domain.Client;
import com.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Herve on 22/02/2017.
 */

@Service
public class ClientService {

    private Logger logger = LoggerFactory.getLogger(ClientService.class);
    private ClientRepository clientRepository;
    private MongoTemplate mongoTemplate;

    @Autowired
    public ClientService (ClientRepository clientRepository, MongoTemplate mongoTemplate){
        this.clientRepository = clientRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public List<Client> findAll () {
        return clientRepository.findAll();
    }

    public List<Client> findByName (String name) {
        BasicQuery query = new BasicQuery("{ last_name : '" + name + "'}");
        //logger.info("search - " + query.toString());
        return mongoTemplate.find(query, Client.class);
    }

    public List<Client> findByPartialName (String name) {

        //Query query = new Query(new Criteria().orOperator(Criteria.where("name").regex(name,"i"),
        //                                                  Criteria.where("first_name").regex(name,"i")));

        Query query = new Query(Criteria.where("name").regex(name,"i"));
        return mongoTemplate.find(query.limit(20), Client.class);
    }

    public void fakeClients (int number) {
        List<Client> clients;

        int chunk = 1000;
        int loop = number / chunk;

        Client client;

        for (int i=0 ; i<loop ; i++) {
            clients = new ArrayList<>();
            for (int j=0 ; j<chunk ; j++) {
                client = new Client();
                client.reset();
                client.fake();
                clients.add(client);
            }
            logger.info("insert "+chunk+" clients");
            clientRepository.insert(clients);
        }
    }
}
