package com.gcucapstone.paychexdashboard.repository;

import com.gcucapstone.paychexdashboard.entity.LookupTable;
import com.gcucapstone.paychexdashboard.entity.LookupType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

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

    //----------------------------------------------------
    // Query Method Definitions
    //----------------------------------------------------

    //---------------------------------------
    // *** Find By Individual Attributes ***
    //---------------------------------------

    /**
     * This method returns a LookupTable record that has a lookupId
     * attribute that matches the passed parameter.
     * @param lookupId  - the lookupId to search for
     * @return          - the LookupTable record
     */
    LookupTable findByLookupId(Long lookupId);

    /**
     * This method returns a List of LookupTable record that has an abbreviation
     * attribute that matches the passed parameter
     * @param abbreviation  - the abbreviation to search for
     * @return              - the LookupTable records List
     */
   List<LookupTable> findByAbbreviation(String abbreviation);

    /**
     * This method returns a list of LookupTable records that has a Description
     * attribute that matches the passed parameter
     * @param description   - the description attribute to search for
     * @return              - the LookupTable records List
     */
    List<LookupTable> findByDescription(String description);

    /**
     * This method returns a List of LookupTable Records that have a fullName
     * attribute that matches the passed parameter.
     * @param fullName  - the fullname to search for
     * @return          - the List of LookupTable record(s)
     */
    List<LookupTable> findByFullName(String fullName);

    /**
     * This method returns a List of LookupTable records that have a
     * lookupType attribute that match the passed parameter.
     * @param lookupType    - the lookupType to search for
     * @return              - LookupTable Record
     */
    LookupTable findByLookupTypeId(LookupType lookupType);

    //---------------------------------------
    // *** Find by Multiple Attributes
    //---------------------------------------
} // LookupTableRepository Interface
