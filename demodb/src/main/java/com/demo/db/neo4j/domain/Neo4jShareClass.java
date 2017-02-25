package com.demo.db.neo4j.domain;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by herve on 14-Feb-17.
 */

@Getter
@Setter
@NodeEntity
public class Neo4jShareClass {
    @GraphId private Long id;

    private String name;
    private String distribution;

    public Neo4jShareClass() {
    }

    public Neo4jShareClass(String name, String distribution) {
        this.name = name;
        this.distribution = distribution;
    }
}
