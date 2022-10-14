package com.gcucapstone.paychexdashboard.repository;

import com.gcucapstone.paychexdashboard.entity.LookupType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created) 10-14-2022
 * File:           | LookupTypeRepository.java
 * Version:        | 1.0
 * Description:    | This interface is where JPA Repository methods, JPQL, and
 *                 | Natice SQL Queries will be defined for LookupType Entities
 * ---------------------------------------------------------------------------
 * Notes:
 *  - Add General Save(create), find, update, and delete methods for the interface
 * ---------------------------------------------------------------------------*/
public interface LookupTypeRepository extends JpaRepository<LookupType, Long> {

    /**
     * This method returns the Optional which contains the retrieved LookupType entry
     *  corresponding to the passes Id parameter
     * @param id   - the id of the LookupType Record to be searched for
     * @return     - the Optional / LookupType Object
     */
    Optional<LookupType> findById(Long id);

    List<LookupType> findByLookupTypeIdOrLookupType(Long id, String type);

    List<LookupType> findByLookupTypeIdAndLookupType(Long id, String type);

}// LookupTypeRepository Interface
