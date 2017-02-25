package com.demo.controller;

import com.demo.domain.Client;
//import com.demo.service.ClientService;
import com.demo.service.ClientService;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Herve on 22/02/2017.
 */

@RestController
@SuppressWarnings("unused")
public class SearchController {

    private final ClientService clientService;


    @Autowired
    public SearchController (ClientService clientService) {
        this.clientService = clientService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/searchAll")
    @ResponseBody
    public List<Client> getClients () {
        return clientService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/search")
    @ResponseBody
    public List<Client> getClients (@RequestParam(value="name") String name) {
        return clientService.findByName(name);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/searchPartial")
    @ResponseBody
    public List<Client> getClientsPartial (@RequestParam(value="name") String name) {
        return clientService.findByPartialName(name);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/fakeClients")
    public ResponseEntity<?> fakeClients (@RequestParam(value="number") String number) {
        clientService.fakeClients(Integer.parseInt(number));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
