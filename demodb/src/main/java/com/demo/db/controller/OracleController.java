package com.demo.db.controller;

import com.demo.db.oracle.domain.OracleFund;
import com.demo.db.oracle.domain.OracleSubFund;
import com.demo.db.oracle.service.OracleFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by herve on 17-Feb-17.
 */

@RestController
public class OracleController {

    private final OracleFundService oracleFundService;

    @Autowired
    public OracleController (OracleFundService oracleFundService) {
        this.oracleFundService = oracleFundService;
    }

    @RequestMapping("/oracle/addFund")
    public OracleFund addFund(@RequestParam(value="id") String id,
                              @RequestParam(value="name") String name,
                              @RequestParam(value="type") String type) {
        return oracleFundService.addFund(new OracleFund(id, name, type));
    }

    @RequestMapping("/oracle/addSubFund")
    public OracleSubFund addSubFund(@RequestParam(value="fundId") String fundId,
                                    @RequestParam(value="subFundId") String subFundId,
                                    @RequestParam(value="name") String name,
                                    @RequestParam(value="ccy") String currency) {
        return oracleFundService.addSubFund(fundId, new OracleSubFund(subFundId, name, currency));
    }

}
