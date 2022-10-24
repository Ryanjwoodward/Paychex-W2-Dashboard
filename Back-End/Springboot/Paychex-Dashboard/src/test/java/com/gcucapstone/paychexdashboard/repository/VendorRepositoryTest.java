package com.gcucapstone.paychexdashboard.repository;

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

    //-----------------------------------
    // Variables
    //-----------------------------------
    @Autowired
    VendorRepository vendorRepository;

    //----------------------------------------------------
    // Query Test Methods
    //----------------------------------------------------

    //--------------------------------
    // Find by Individual Attributes
    //--------------------------------

    @Test
    void findByBranch(){
        List<Vendor> vendor = vendorRepository.findByBranch("northwest");

        vendor.forEach((v)->{
            System.out.println("EMP COUNT: " + v.getEmployeeCount());
            System.out.println("W2 COUNT: " + v.getW2Count());
        });
    }

    @Test
    void findByClientId(){
        List<Vendor> vendor = vendorRepository.findByClientId("7765-DG");
        vendor.forEach((v)->{
            System.out.println("EMP COUNT: " + v.getEmployeeCount());
            System.out.println("W2 COUNT: " + v.getW2Count());
        });
    }

    @Test
    void findByEmployeeCount(){
        List<Vendor> vendors = vendorRepository.findByEmployeeCount(117);
        vendors.forEach((v)->{
            System.out.println("EMP COUNT: " + v.getEmployeeCount());
            System.out.println("BRANCH: " + v.getVendorId().getBranch());
        });
    }

    @Test
    void findByEmployeeCountGreaterThan(){
        List<Vendor> vendors = vendorRepository.findByEmployeeCountGreaterThan(50);
        vendors.forEach((v)->{
            System.out.println("EMP COUNT: " + v.getEmployeeCount());
            System.out.println("BRANCH: " + v.getVendorId().getBranch());
        });
    }

    @Test
    void findByEmployeeCountLessThan(){
        List<Vendor> vendors = vendorRepository.findByEmployeeCountLessThan(200);
        vendors.forEach((v)->{
            System.out.println("EMP COUNT: " + v.getEmployeeCount());
            System.out.println("BRANCH: " + v.getVendorId().getBranch());
        });
    }

    @Test
    void findByEmployeeCountBetween(){
        List<Vendor> vendors = vendorRepository.findByEmployeeCountBetween(10, 200);
        vendors.forEach((v)->{
            System.out.println("EMP COUNT: " + v.getEmployeeCount());
            System.out.println("BRANCH: " + v.getVendorId().getBranch());
        });
    }

    @Test
    void findByW2Count(){
        List<Vendor> vendors = vendorRepository.findByW2Count(117);
        vendors.forEach((v)->{
            System.out.println("EMP COUNT: " + v.getEmployeeCount());
            System.out.println("BRANCH: " + v.getVendorId().getBranch());
        });
    }

    @Test
    void findByW2CountGreaterThan(){
        List<Vendor> vendors = vendorRepository.findByW2CountGreaterThan(25);
        vendors.forEach((v)->{
            System.out.println("EMP COUNT: " + v.getEmployeeCount());
            System.out.println("BRANCH: " + v.getVendorId().getBranch());
        });
    }

    @Test
    void findByW2CountGLessThan(){
        List<Vendor> vendors = vendorRepository.findByW2CountLessThan(200);
        vendors.forEach((v)->{
            System.out.println("EMP COUNT: " + v.getEmployeeCount());
            System.out.println("BRANCH: " + v.getVendorId().getBranch());
        });
    }

    @Test
    void findByCW2CountBetween(){
        List<Vendor> vendors = vendorRepository.findByW2CountBetween(10, 200);
        vendors.forEach((v)->{
            System.out.println("EMP COUNT: " + v.getEmployeeCount());
            System.out.println("BRANCH: " + v.getVendorId().getBranch());
        });
    }

    //--------------------------------
    // Find by Multiple Attributes
    //--------------------------------
    @Test
    void findByBranchOrClientId(){

        List<Vendor> vendor = vendorRepository.findByBranchOrClientId("northwest", "765-DG");

        vendor.forEach((v)->{
            System.out.println("EMP COUNT: " + v.getEmployeeCount());
            System.out.println("W2 COUNT: " + v.getW2Count());
        });
    }


}// VendorRepositoryTest Class
