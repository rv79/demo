package com.demo.db.neo4j.domain;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by herve on 14-Feb-17.
 */

@Setter
@Getter
@NodeEntity
public class Neo4jFund {
    @GraphId private Long id;

    private String fundId;
    private String name;
    private String type;

    @Relationship(type="FUND_OF",direction = Relationship.UNDIRECTED)
    private Set<Neo4jSubFund> neo4jSubFunds;

    public Neo4jFund() {
    }

    public Neo4jFund(String fundId, String name, String type) {
        this.fundId = fundId;
        this.name = name;
        this.type = type;
    }

    public void addSubFund (Neo4jSubFund neo4jSubFund) {
        if (neo4jSubFunds == null) { neo4jSubFunds = new HashSet<>(); }
        neo4jSubFunds.add(neo4jSubFund);
    }

}
