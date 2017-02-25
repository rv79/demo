package com.demo.db.neo4j.service;

import com.demo.db.neo4j.domain.Neo4jFund;
import com.demo.db.neo4j.domain.Neo4jShareClass;
import com.demo.db.neo4j.domain.Neo4jSubFund;
import com.demo.db.neo4j.repository.Neo4jFundRepository;
import com.demo.db.neo4j.repository.Neo4jShareClassRepository;
import com.demo.db.neo4j.repository.Neo4jSubFundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by herve on 14-Feb-17.
 */

@Service
public class Neo4jFundService {

    @Autowired
    private Neo4jFundRepository neo4jFundRepository;
    @Autowired
    private Neo4jSubFundRepository neo4jSubFundRepository;
    @Autowired
    private Neo4jShareClassRepository neo4jShareClassRepository;

    public Neo4jFund addFund (Neo4jFund neo4jFund) {
        neo4jFundRepository.save(neo4jFund);
        return neo4jFund;
    }

    public Neo4jSubFund addSubFund (String fundId, Neo4jSubFund neo4jSubFund) {
        // create the sub neo4jFund
        neo4jSubFundRepository.save(neo4jSubFund);
        // link the sub neo4jFund to the neo4jFund
        Neo4jFund neo4jFund = neo4jFundRepository.findByFundId(fundId);
        neo4jFund.addSubFund(neo4jSubFund);
        neo4jFundRepository.save(neo4jFund);

        return neo4jSubFund;
    }

    public Neo4jShareClass addShareClass (String subFundId, Neo4jShareClass neo4jShareClass) {
        // create the share class
        neo4jShareClassRepository.save(neo4jShareClass);
        // link the share class to the sub fund
        Neo4jSubFund neo4jSubFund = neo4jSubFundRepository.findBySubFundId(subFundId);
        neo4jSubFund.addShareClass(neo4jShareClass);
        neo4jSubFundRepository.save(neo4jSubFund);

        return neo4jShareClass;
    }
}
