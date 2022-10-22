package com.gcucapstone.paychexdashboard.repository;

import com.gcucapstone.paychexdashboard.entity.BranchClient;
import com.gcucapstone.paychexdashboard.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-21-2022
 * File:           | VendorRepository.java
 * Version:        | 1.0
 * Description:    |This interface file is where JPARepository Methods, JPQL and
 *                 | native SQL Query methods will be defined for Vendor entities
 * ---------------------------------------------------------------------------
 */
public interface VendorRepository extends JpaRepository<Vendor, BranchClient> {

   //for BranchClient attribute - I will have to write custom Query method

   @Query("SELECT v from Vendor v where v.vendorId.branch = ?1 or v.vendorId.clientId = ?2")
   List<Vendor> findByBranchOrClientId(String branch, String clientId);

   @Query("SELECT v from Vendor v WHERE v.vendorId.branch = ?1")
   List<Vendor> findByBranch(String Branch);

}// VendorRepository Interface
