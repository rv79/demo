package com.demo.db.mongo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by herve on 15-Feb-17.
 */

@Getter
@Setter
@Document(collection = "Funds")
public class MongoFund {
    @Id private String id;

    private String fundId;
    private String name;
    private String type;

    @Field("SubFunds")
    private Collection<MongoSubFund> mongoSubFunds;

    public MongoFund() {
    }

    public MongoFund(String fundId, String name, String type) {
        this.fundId = fundId;
        this.name = name;
        this.type = type;
    }

    public MongoSubFund addSubFund (MongoSubFund mongoSubFund) {
        if (this.mongoSubFunds == null) { this.mongoSubFunds = new HashSet<>(); }
        this.mongoSubFunds.add(mongoSubFund);
        return mongoSubFund;
    }
}
