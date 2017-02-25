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

@Getter
@Setter
@NodeEntity
public class Neo4jSubFund {
    @GraphId private Long id;

    private String subFundId;
    private String name;
    private String currency;

    @Relationship(type="SHARE_OF",direction = Relationship.UNDIRECTED)
    private Set<Neo4jShareClass> neo4jShareClasses;


    public Neo4jSubFund() {
    }

    public Neo4jSubFund(String subFundId, String name, String currency) {
        this.subFundId = subFundId;
        this.name = name;
        this.currency = currency;
    }

    public void addShareClass (Neo4jShareClass neo4jShareClass) {
        if (neo4jShareClasses == null) { neo4jShareClasses = new HashSet<>(); }
        neo4jShareClasses.add(neo4jShareClass);
    }
}
