package com.demo.db.controller;

import com.demo.db.neo4j.domain.Neo4jFund;
import com.demo.db.neo4j.domain.Neo4jShareClass;
import com.demo.db.neo4j.domain.Neo4jSubFund;
import com.demo.db.neo4j.service.Neo4jFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by herve on 14-Feb-17.
 */

@RestController
public class Neo4jController {

    private final Neo4jFundService neo4jFundService;

    @Autowired
    public Neo4jController (Neo4jFundService neo4jFundService) {
        this.neo4jFundService = neo4jFundService;
    }

    @RequestMapping("/neo4j/addFund")
    public Neo4jFund addFund(@RequestParam(value="id") String id,
                             @RequestParam(value="name") String name,
                             @RequestParam(value="type") String type) {
        return neo4jFundService.addFund(new Neo4jFund(id, name, type));
    }

    @RequestMapping("/neo4j/addSubFund")
    public Neo4jSubFund addSubFund(@RequestParam(value="fundId") String fundId,
                                   @RequestParam(value="subFundId") String subFundId,
                                   @RequestParam(value="name") String name,
                                   @RequestParam(value="ccy") String currency) {
        return neo4jFundService.addSubFund(fundId, new Neo4jSubFund(subFundId, name, currency));
    }

    @RequestMapping("/neo4j/addShareClass")
    public Neo4jShareClass addShareClass(@RequestParam(value="subFundId") String subFundId,
                                         @RequestParam(value="name") String name,
                                         @RequestParam(value="distribution") String distribution) {
        return neo4jFundService.addShareClass(subFundId, new Neo4jShareClass(name, distribution));
    }

}
