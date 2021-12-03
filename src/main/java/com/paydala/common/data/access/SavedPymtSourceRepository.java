package com.paydala.common.data.access;

import com.paydala.common.data.entity.SavedPymtSource;
import com.paydala.common.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SavedPymtSourceRepository extends JpaRepository<SavedPymtSource, Integer> {

    List<SavedPymtSource> findByUser(@Param("user") User user);

    List<SavedPymtSource> findByUser(@Param("user") String email);
    
    List<SavedPymtSource> findByUserId(@Param("user") Integer id );

}