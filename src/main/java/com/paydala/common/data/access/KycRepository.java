/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paydala.common.data.access;

import com.paydala.common.data.entity.Kyc;
import com.paydala.common.data.entity.SavedPymtSource;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Susheela
 */
public interface KycRepository  extends JpaRepository<Kyc, Integer>{
    List<Kyc> findByUserId(@Param("user") Integer id );
}
