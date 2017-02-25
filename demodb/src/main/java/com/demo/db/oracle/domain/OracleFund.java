package com.demo.db.oracle.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by herve on 17-Feb-17.
 */

@Getter
@Setter
@Entity
@Table(name="FUNDS", schema="HERVE")
public class OracleFund {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="FUND_ID_OLD")
    private String fundIdOld;
    @Column(name="NAME")
    private String name;
    @Column(name="TYPE")
    private String type;

    @OneToMany(mappedBy = "oracleFund", cascade = CascadeType.ALL)
    private Collection<OracleSubFund> oracleSubFunds;

    public OracleFund() {
    }

    public OracleFund(String fundIdOld, String name, String type) {
        this.fundIdOld = fundIdOld;
        this.name = name;
        this.type = type;
    }

    public OracleSubFund addSubFund (OracleSubFund oracleSubFund) {
        if (this.oracleSubFunds == null) { this.oracleSubFunds = new HashSet<>(); }
        this.oracleSubFunds.add(oracleSubFund);
        return oracleSubFund;
    }

}
