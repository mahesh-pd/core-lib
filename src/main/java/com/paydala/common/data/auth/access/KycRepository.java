/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paydala.common.data.auth.access;

import com.paydala.common.data.auth.entity.Kyc;
import java.util.Date;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Susheela
 */
public interface KycRepository  extends JpaRepository<Kyc, Integer>{
    List<Kyc> findByUserId(@Param("user") Integer id ); 
    
    List<Kyc> findByLastKycBetween(@Param("lastkyc") Date fromDate, @Param("laskyyc") Date toDate);
    
    @Modifying
    @Query("select k from Kyc k where k.lastKyc between :fromDate and :toDate and k.status=:status")
    List<Kyc> findByLastKycBetweenAndStatus(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate, @Param("status") Boolean status);
    
}
