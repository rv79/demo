package com.demo.db.oracle.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by herve on 17-Feb-17.
 */

@Getter
@Setter
@Entity
@Table(name="SUB_FUNDS")
public class OracleSubFund {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FUND_ID")
    private OracleFund oracleFund;
    @Column(name="SUB_FUND_ID")
    private String subFundId;
    @Column(name="NAME")
    private String name;
    @Column(name="CURRENCY")
    private String currency;

    public OracleSubFund () {
    }

    public OracleSubFund (String subFundId, String name, String currency) {
        this.subFundId = subFundId;
        this.name = name;
        this.currency = currency;
    }

}
