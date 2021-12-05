package com.paydala.common.data.auth.access;

import com.paydala.common.data.auth.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer>, JpaSpecificationExecutor<User> {
    List<User> findByEmail(@Param("email") String email);
}
