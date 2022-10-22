package com.gcucapstone.paychexdashboard.repository;

import com.gcucapstone.paychexdashboard.entity.LookupTable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-21-2022
 * File:           | LookupTableRepository.java
 * Version:        | 1.0
 * Description:    |This interface file is where JPARepository Methods, JPQL and
 *                 | native SQL Query methods will be defined for LookupTable entities
 * ---------------------------------------------------------------------------
 */
public interface LookupTableRepository extends JpaRepository<LookupTable, Long> {

    // finder query methods for all attributes

} // LookupTableRepository Interface
