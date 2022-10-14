package com.gcucapstone.paychexdashboard.repository;

import com.gcucapstone.paychexdashboard.entity.BranchClient;
import com.gcucapstone.paychexdashboard.entity.Carrier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created) 10-14-2022
 * File:           | CarrierRepository.java
 * Version:        | 1.0
 * Description:    | This interface file is where JPARepository Methods, JPQL and
 *                 | native SQL Query methods will be defind for Carrier entities
 * ---------------------------------------------------------------------------
 * Notes:
 *  - Add General Save(create), find, update, and delete methods for the interface
 *
 *---------------------------------------------------------------------------*/
public interface CarrierRepository extends JpaRepository<Carrier, BranchClient> {

    Optional<Carrier> findById(BranchClient id);

    //carrier type

    //delivery status type

    //destination address

    //tracking id

}// CarrierRepository Interface
