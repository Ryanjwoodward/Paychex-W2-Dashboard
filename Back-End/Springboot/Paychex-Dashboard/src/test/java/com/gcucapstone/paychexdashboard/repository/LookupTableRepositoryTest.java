package com.gcucapstone.paychexdashboard.repository;

import com.gcucapstone.paychexdashboard.entity.LookupTable;
import com.gcucapstone.paychexdashboard.entity.LookupType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-26-2022
 * File:           | LookupTableRepositoryTest.java
 * Version:        | 1.0
 * Description:    | This file will be used to test the repo query methods
 *                 | defined in the LookupTableRepository interface
 * ---------------------------------------------------------------------------
 */
@SpringBootTest
public class LookupTableRepositoryTest {

    //----------------------------------------------------
    // Instance Variables
    //----------------------------------------------------
    @Autowired
    LookupTableRepository lookupTableRepository;

    @Autowired
    LookupTypeRepository lookupTypeRepository;

    //----------------------------------------------------
    // Query Test Methods
    //----------------------------------------------------

    //--------------------------------
    // Find by Individual Attributes
    //--------------------------------

    @Test
    void findByLookupId(){
        LookupTable lookupTable = lookupTableRepository.findByLookupId(1234L);
        System.out.println("Lookup ID: " + lookupTable.getLookupId());
        System.out.println("ABBREV: " + lookupTable.getAbbreviation());
    }

    @Test
    void findByAbbreviation(){
        List<LookupTable> tables = lookupTableRepository.findByAbbreviation("VEN");
        tables.forEach((t) -> {
            System.out.println("Lookup ID: " + t.getLookupId());
            System.out.println("ABBREV: " + t.getAbbreviation());
        });
    }

    @Test
    void findByDescription(){
        List<LookupTable> tables = lookupTableRepository.findByDescription("vendor description");
        tables.forEach((t) -> {
            System.out.println("Lookup ID: " + t.getLookupId());
            System.out.println("ABBREV: " + t.getAbbreviation());
        });
    }

    @Test
    void findByFullName(){
        List<LookupTable> tables = lookupTableRepository.findByFullName("vendor name");
        tables.forEach((t) -> {
            System.out.println("Lookup ID: " + t.getLookupId());
            System.out.println("ABBREV: " + t.getAbbreviation());
        });
    }

    @Test
    void findByLookupTypeId(){
        LookupType type = lookupTypeRepository.findById(1234L).get();

        System.out.println("TYPE: "+ type.getLookupType());
        System.out.println("ID: "+ type.getLookupTypeId());

        LookupTable table = lookupTableRepository.findByLookupTypeId(type);

        System.out.println("ABBREV: "+ table.getAbbreviation());
        System.out.println("DESCR: "+ table.getDescription());
    }

    //--------------------------------
    // Find by Multiple Attributes
    //--------------------------------

}//LookupTableRepositoryTest Class
