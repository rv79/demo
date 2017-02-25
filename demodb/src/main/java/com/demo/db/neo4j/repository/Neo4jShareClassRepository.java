package com.demo.db.neo4j.repository;

import com.demo.db.neo4j.domain.Neo4jShareClass;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by herve on 14-Feb-17.
 */

public interface Neo4jShareClassRepository extends GraphRepository<Neo4jShareClass> {
    Neo4jShareClass findByName (String name);
}
