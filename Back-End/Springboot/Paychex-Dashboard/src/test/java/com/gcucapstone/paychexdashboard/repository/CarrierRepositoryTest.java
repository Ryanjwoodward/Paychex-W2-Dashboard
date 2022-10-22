package com.gcucapstone.paychexdashboard.repository;

import com.gcucapstone.paychexdashboard.entity.BranchClient;
import com.gcucapstone.paychexdashboard.entity.Carrier;
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
 * Date:           | (Created) 10-14-2022
 * File:           | CarrierRepositoryTest.java
 * Version:        | 1.0
 * Description:    | This file wil be used to test the repo & query methods
 *                 | defined in the CarrierRepository interface
 * ---------------------------------------------------------------------------
 * Notes:
 *
 *---------------------------------------------------------------------------*/
@SpringBootTest
public class CarrierRepositoryTest {

    //----------------------------------------------------
    // Fields
    //----------------------------------------------------
    @Autowired
    private CarrierRepository carrierRepository;

    //----------------------------------------------------
    // Query Methods Test Methods
    //----------------------------------------------------

    //---------------------------------------
    // *** Find By Individual Attributes ***
    //---------------------------------------

    //---------------------------------------
    // *** Find By Multiple Attributes ***
    //---------------------------------------

}// CarrierRepositoryTest Class
