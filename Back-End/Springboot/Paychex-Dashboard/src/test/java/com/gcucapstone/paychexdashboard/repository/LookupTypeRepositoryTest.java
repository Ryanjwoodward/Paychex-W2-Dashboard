package com.gcucapstone.paychexdashboard.repository;

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
 * Date:           | (Created) 10-14-2022
 * File:           | LookupTypeRepositoryTest.java
 * Version:        | 1.0
 * Description:    | This file will be used to test the repo @ query methods
 *                 | defined in the LookupTypeRepository interface
 * ---------------------------------------------------------------------------
 * Notes:
 *  - Add JUnit test methods for each CarrierRepo method as they are coded
 *---------------------------------------------------------------------------*/
@SpringBootTest
public class LookupTypeRepositoryTest {

    //----------------------------------------------------
    // Instance Variables
    //----------------------------------------------------
    @Autowired
    private LookupTypeRepository lookupTypeRepository;

    //----------------------------------------------------
    // Query Test Methods
    //----------------------------------------------------

    //--------------------------------
    // Find by Individual Attributes
    //--------------------------------
    /**
     * This method is used to test a dev-defined method that uses SB-JPA keywords:
     * findById which locates the record with the passed ID parameter. This method
     * then prints the attributes of that record
     */
    @Test
    void findByIdMethod(){
        Long id = 1234L;
        LookupType lookupType = lookupTypeRepository.findById(id).get();

        System.out.println("ID: " + lookupType.getLookupTypeId());
        System.out.println("TYPE: " + lookupType.getLookupType());
    }

    /**
     * This overloaded method is a used to test a dev-defined method that uses SB-JPA keywords:
     * findById which locates the record with the passed ID parameter. This method
     * then prints the attributes of that record
     * @param id - the id of the record to search for
     */
    @Test
    void findByIdMethod(Long id){

        LookupType lookupType = lookupTypeRepository.findById(id).get();
        System.out.println("ID: " + lookupType.getLookupTypeId());
        System.out.println("TYPE: " + lookupType.getLookupType());
    }

    /**
     * This method is used to test a JPARepository defined method findAll
     * This method simply obtains all the records corresponding to this
     * database entity then prints each of the records fields.
     */
    @Test
    void findAllMethod(){
        List<LookupType> lookupTypes = lookupTypeRepository.findAll();

        lookupTypes.forEach((l) -> {
            System.out.println("TYPE: " + l.getLookupType());
            System.out.println("ID: " + l.getLookupTypeId());
        });
    }

    /**
     * This method is used to test a dev-defined method that uses SB-JPA keywords:
     * findByLookupTypeMethod which locates all records by the lookupType entity's
     * attribute of (lookup) Type. This method then prints out fields of each record.
     */
    @Test
    void findByLookupTypeMethod(){
        String type = "carrier";

        List<LookupType> lookupTypes = lookupTypeRepository.findByLookupType(type);

        lookupTypes.forEach((l) ->{
            System.out.println("ID: " + l.getLookupTypeId());
            System.out.println("TYPE: " + l.getLookupType());
        });
    }

    //--------------------------------
    // Find by Multiple Attributes
    //--------------------------------
    /**
     * This method is used to test a dev-defined method that uses SB-JPA keywords:
     * findByIdOrLookupType which locates all records that have a matching Id OR
     * lookupType attribute. This method then prints out fields of each record.
     */
    @Test
    void findByIdOrTypeMethod(){
        Long id = 1008L;
        String type = "carrier";

        List<LookupType> lookupTypes = lookupTypeRepository.findByLookupTypeIdOrLookupType(id, type);

        lookupTypes.forEach((l) ->{
            System.out.println("ID: " + l.getLookupTypeId());
            System.out.println("TYPE: " + l.getLookupType());
        });
    }

    /**
     * This method is used to test a dev-defined method that uses SB-JPA keywords:
     * findByIdAndLookupType which locates all records that have a matching Id &
     * lookupType attribute. This method then prints out fields of each record
     */
    @Test
    void findByIdAndTypeMethod(){
        Long id = 1008L;
        String type = "carrier";

        List<LookupType> lookupTypes = lookupTypeRepository.findByLookupTypeIdAndLookupType(id, type);

        lookupTypes.forEach((l) ->{
            System.out.println("ID: " + l.getLookupTypeId());
            System.out.println("TYPE: " + l.getLookupType());
        });
    }

    //----------------------
    // SAVE Methods
    //----------------------

    /**
     * This method is used to test a JPARepository defined method save()
     * This method saves a new record to the table and then call the
     * overloaded findById method to verify the record was saved
     */
    @Test
    void saveMethod(){

        LookupType lookupType = new LookupType();
        lookupType.setLookupTypeId(3204L);
        lookupType.setLookupType("developer");

        LookupType savedObj = lookupTypeRepository.save(lookupType);
        System.out.println("Check to see if Record was saved...");
        findByIdMethod(lookupType.getLookupTypeId());
    }

    //----------------------
    // DELETE Methods
    //----------------------
    /**
     * This method is used to test a JPARepository method deleteAll which
     * will remove all records from the entity
     */
    @Test
    void deleteAllMethod(){

        lookupTypeRepository.deleteAll();
    }

    /**
     * This method is used to test a JPARepository method deleteById which
     *  removes the record with an Id that matches the parameter
     */
    @Test
    void deleteByIdMethod(){
        Long id = 1234L;

        lookupTypeRepository.deleteById(id);
    }

    //deleteAll(passed list)

    // exists and count method

}// LookupTypeRepositoryTest Class
