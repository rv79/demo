package com.demo.db.oracle.repository;

import com.demo.db.oracle.domain.OracleFund;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by herve on 17-Feb-17.
 */

public interface OracleFundRepository extends CrudRepository<OracleFund, Long> {
    OracleFund findByFundIdOld (String fundIdOld);
}
