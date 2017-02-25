package com.demo.db.mongo.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by herve on 15-Feb-17.
 */

@Getter
@Setter
@Document(collection = "SubFunds")
public class MongoSubFund {

    private String subFundId;
    private String name;
    private String currency;

    public MongoSubFund(String subFundId, String name, String currency) {
        this.subFundId = subFundId;
        this.name = name;
        this.currency = currency;
    }
}
