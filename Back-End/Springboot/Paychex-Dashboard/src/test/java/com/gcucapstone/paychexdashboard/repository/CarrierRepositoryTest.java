package com.gcucapstone.paychexdashboard.repository;

import com.gcucapstone.paychexdashboard.entity.BranchClient;
import com.gcucapstone.paychexdashboard.entity.Carrier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
 *  - Add JUnit test methods for each CarrierRepo method as they are coded
 *
 *---------------------------------------------------------------------------*/
@SpringBootTest
public class CarrierRepositoryTest {

    @Autowired
    private CarrierRepository carrierRepository;

    @Test
    void findByIdMethod(){

        BranchClient bc = new BranchClient();
        bc.setBranch("nothwest");
        bc.setClientId("UPS");

        Carrier carrier = carrierRepository.findById(bc).get();

        System.out.println("CId: " + carrier.getCarrierId());
        System.out.println("Ctype: " + carrier.getCarrierType());
        System.out.println("DStatType: " + carrier.getDeliveryStatusType());
    }


}// CarrierRepositoryTest Class
