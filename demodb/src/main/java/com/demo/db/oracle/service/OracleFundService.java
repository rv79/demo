package com.demo.db.oracle.service;

import com.demo.db.oracle.domain.OracleFund;
import com.demo.db.oracle.domain.OracleSubFund;
import com.demo.db.oracle.repository.OracleFundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by herve on 17-Feb-17.
 */

@Service
public class OracleFundService {

    @Autowired
    private OracleFundRepository oracleFundRepository;

    public OracleFund addFund (OracleFund oracleFund) {
        oracleFundRepository.save(oracleFund);
        return oracleFund;
    }


    public OracleSubFund addSubFund (String fundIdOld, OracleSubFund oracleSubFund) {
        OracleFund oracleFund = oracleFundRepository.findByFundIdOld(fundIdOld);

        if (oracleFund != null) {
            oracleFund.addSubFund(oracleSubFund);
            oracleFundRepository.save(oracleFund);
            return oracleSubFund;
        } else {
            return new OracleSubFund("not found", "not found", "not found");
        }
    }

}
