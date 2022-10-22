package com.gcucapstone.paychexdashboard.repository;

import com.gcucapstone.paychexdashboard.entity.BranchClient;
import com.gcucapstone.paychexdashboard.entity.Vendor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-21-2022
 * File:           | VendorRepositoryTest.java
 * Version:        | 1.0
 * Description:    | This file will be used to test the repo at query methods
 *                 | defined in the VendorRepository interface
 * ---------------------------------------------------------------------------
 */
@SpringBootTest
public class VendorRepositoryTest {

    @Autowired
    VendorRepository vendorRepository;


    @Test
    void findByBranchOrClientId(){

        List<Vendor> vendor = vendorRepository.findByBranchOrClientId("northwest", "765-DG");

        vendor.forEach((v)->{
            System.out.println("EMP COUNT: " + v.getEmployeeCount());
            System.out.println("W2 COUNT: " + v.getW2Count());
        });
    }


    @Test
    void findByBranch(){
        List<Vendor> vendor = vendorRepository.findAll();

        vendor.forEach((v)->{
            System.out.println("EMP COUNT: " + v.getEmployeeCount());
            System.out.println("W2 COUNT: " + v.getW2Count());
        });
    }

}// VendorRepositoryTest Class
