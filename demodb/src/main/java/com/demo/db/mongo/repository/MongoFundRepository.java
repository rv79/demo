package com.demo.db.mongo.repository;

import com.demo.db.mongo.domain.MongoFund;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Created by herve on 15-Feb-17.
 */

@Document(collection="Funds")
public interface MongoFundRepository extends MongoRepository<MongoFund, String> {

    //@Query("{'fundId':?0}")
    MongoFund findByFundId (String fundId);
}
