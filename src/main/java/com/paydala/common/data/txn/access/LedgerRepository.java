package com.paydala.common.data.txn.access;

import com.paydala.common.data.auth.entity.User;
import com.paydala.common.data.txn.entity.Ledger;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LedgerRepository extends CrudRepository<Ledger, Integer>, JpaSpecificationExecutor<User> {
    //List<User> findByEmail(@Param("email") String email);
}
