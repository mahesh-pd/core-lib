package com.paydala.common.data.access;

import com.paydala.common.data.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository1 extends CrudRepository<User, Integer>, JpaSpecificationExecutor<User> {
}