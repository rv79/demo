package com.demo.db.mongo.service;

import com.demo.db.mongo.domain.MongoFund;
import com.demo.db.mongo.domain.MongoSubFund;
import com.demo.db.mongo.repository.MongoFundRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by herve on 15-Feb-17.
 */

@Service
public class MongoFundService {

    @Autowired
    private MongoFundRepository mongoFundRepository;

    public MongoFund addFund (MongoFund mongoFund) {
        mongoFundRepository.save(mongoFund);
        return mongoFund;
    }

    public MongoSubFund addSubFund (String fundId, MongoSubFund mongoSubFund) {
        MongoFund mongoFund = mongoFundRepository.findByFundId(fundId);

        if (mongoFund != null) {
            mongoFund.addSubFund(mongoSubFund);
            mongoFundRepository.save(mongoFund);
            return mongoSubFund;
        } else {
            return null;
        }
    }
}
