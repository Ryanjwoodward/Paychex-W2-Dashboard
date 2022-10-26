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

    //----------------------------------------------------
    // Method Definitions
    //----------------------------------------------------

    //--------------------------------
    // Find by Individual Attributes
    //--------------------------------
    /**
     * This method returns the Optional which contains the retrieved LookupType entry
     *  corresponding to the passed Id parameter
     * @param id   - the id of the LookupType Record to be searched for
     * @return     - the Optional / LookupType Object
     */
    Optional<LookupType> findById(Long id);

    /**
     *  This method returns a list of LookupType records that have a type attribute
     *  of the passed parameter.
     * @param type  - the Lookup Type (String) to be searched for
     * @return      - the retrieved list of LookupType records
     */
    List<LookupType> findByLookupType(String type);

    //--------------------------------
    // Find by Multiple Attributes
    //--------------------------------
    /**
     *  This method returns a list of LookupType entities that consist of at least
     *  one of the parameters passed (id or type).
     * @param id    - the id of the LookupType Records to search for
     * @param type  - the type of the LookupType records to search for
     * @return      - the retrieved list of LookupType records
     */
    List<LookupType> findByLookupTypeIdOrLookupType(Long id, String type);

    /**
     * This method returns a list of LookupType entities that consists of both
     *  of the passed parameters (id and type).
     * @param id    - the id of the LookupType records searched for
     * @param type  - the the type of the LookupType records to search for
     * @return      - the retrieved list of the LookupType records
     */
    List<LookupType> findByLookupTypeIdAndLookupType(Long id, String type);

}// LookupTypeRepository Interface
