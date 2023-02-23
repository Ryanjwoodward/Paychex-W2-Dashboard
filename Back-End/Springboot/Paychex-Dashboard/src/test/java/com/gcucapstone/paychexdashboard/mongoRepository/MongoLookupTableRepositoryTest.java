package com.gcucapstone.paychexdashboard.mongoRepository;

import com.gcucapstone.paychexdashboard.models.LookupTable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand CThis anyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-29-2022
 * File:           | MongoLookupTableRepositoryTest.java
 * Version:        | 1.0
 * Description:    | This file will be used to test query methods for &
 *                 | written within the Mongo Repo interface LookupTableRepo
 * ---------------------------------------------------------------------------
 */
@SpringBootTest
public class MongoLookupTableRepositoryTest {

    //----------------------------------------------------
    // Instance Variables
    //----------------------------------------------------

    @Autowired
    private MongoLookupTableRepository lookupTableRepository;

    //----------------------------------------------------
    // Query Methods Tests
    //----------------------------------------------------

    @Test
    void saveLookupTable(){
        lookupTableRepository.save(new LookupTable());
    }

    @Test
    void findAllLookupTables(){
        lookupTableRepository.findAll().forEach((l) -> {
            System.out.println("LOOKUP ID: " + l.getLookupId());
            System.out.println("LOOKUP TYPE: " + l.getLookupTypeId());
            System.out.println("ABBREV: " + l.getAbbreviation());
            System.out.println("DESCSR: " + l.getDescription());
        });
    }

}// MongoLookupTableRepositoryTest Class
