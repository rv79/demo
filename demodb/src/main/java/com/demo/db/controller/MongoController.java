package com.demo.db.controller;

import com.demo.db.mongo.domain.MongoSubFund;
import com.demo.db.mongo.service.MongoFundService;
import com.demo.db.mongo.domain.MongoFund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by herve on 15-Feb-17.
 */

@RestController
public class MongoController {

    private MongoFundService mongoFundService;

    @Autowired
    public MongoController (MongoFundService mongoFundService) {
        this.mongoFundService = mongoFundService;
    }

    @RequestMapping("/mongo/addFund")
    public MongoFund addFund(@RequestParam(value="id") String id,
                             @RequestParam(value="name") String name,
                             @RequestParam(value="type") String type) {
        return mongoFundService.addFund(new MongoFund(id, name, type));
    }

    @RequestMapping("/mongo/addSubFund")
    public MongoSubFund addSubFund(@RequestParam(value="fundId") String fundId,
                                   @RequestParam(value="subFundId") String subFundId,
                                   @RequestParam(value="name") String name,
                                   @RequestParam(value="ccy") String currency) {
        return mongoFundService.addSubFund(fundId, new MongoSubFund(subFundId, name, currency));
    }


}
