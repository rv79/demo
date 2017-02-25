package com.demo.db.neo4j.repository;

import com.demo.db.neo4j.domain.Neo4jFund;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by herve on 14-Feb-17.
 */

public interface Neo4jFundRepository extends GraphRepository<Neo4jFund> {
    Neo4jFund findByName (String name);
    Neo4jFund findByFundId (String fundId);

}
