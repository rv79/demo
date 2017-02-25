package com.demo.db.neo4j.repository;

import com.demo.db.neo4j.domain.Neo4jSubFund;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by herve on 14-Feb-17.
 */

public interface Neo4jSubFundRepository extends GraphRepository<Neo4jSubFund> {
    Neo4jSubFund findByName (String name);
    Neo4jSubFund findBySubFundId (String subFundId);
}
