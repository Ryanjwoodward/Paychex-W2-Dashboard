package com.gcucapstone.paychexdashboard.mongoRepository;

import com.gcucapstone.paychexdashboard.models.Vendor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-28-2022
 * File:           | MongoVendorRepository.java (mongo)
 * Version:        | 1.0
 * Description:    | This File will be used to write Query methods
 *                 | for Mongo Vendor Documents
 * ---------------------------------------------------------------------------
 */
@SpringBootTest
public class MongoVendorRepositoryClass {

    //----------------------------------------------------
    // Instance Variables
    //----------------------------------------------------

    @Autowired
    private MongoVendorRepository vendorRepository;

    //----------------------------------------------------
    // Query Methods Tests
    //----------------------------------------------------

    @Test
    void saveVendor(){
        vendorRepository.save(new Vendor());
    }

    @Test
    void findAllVendors(){
        vendorRepository.findAll().forEach((v) -> {
            System.out.println("BRANCH: " + v.getVendorId().getBranch());
            System.out.println("CLIENT ID: " + v.getVendorId().getClientId());
            System.out.println("TABLE ABBREV: " + v.getLookupId().getAbbreviation());
            System.out.println("EMP COUNT: " + v.getEmployeeCount());
        });
    }

}//MongoVendorRepository Class
