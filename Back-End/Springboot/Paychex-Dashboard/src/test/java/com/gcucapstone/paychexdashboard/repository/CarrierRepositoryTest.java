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

    @Autowired
    private LookupTableRepository lookupTableRepository;

    //----------------------------------------------------
    // Query Methods Test Methods
    //----------------------------------------------------

    //---------------------------------------
    // *** Find By Individual Attributes ***
    //---------------------------------------

    @Test
    void findByBranch(){
            List<Carrier> carriers = carrierRepository.findByBranch("northwest");

            carriers.forEach((c) ->{
                System.out.println("CARRIER ID-BRANCH: " + c.getCarrierId().getBranch());
                System.out.println("ADDRESS: " + c.getDestinationAddress());
            });
    }

    @Test
    void findByClientId(){
        List<Carrier> carriers = carrierRepository.findByClientId("7765-DG");
        carriers.forEach((c) ->{
            System.out.println("CARRIER ID-BRANCH: " + c.getCarrierId().getBranch());
            System.out.println("ADDRESS: " + c.getDestinationAddress());
        });
    }

    @Test
    void findByDestinationAddress(){
        List<Carrier> carriers = carrierRepository.findByDestinationAddress("899 W. Seliger Ave.");
        carriers.forEach((c) ->{
            System.out.println("CARRIER ID-BRANCH: " + c.getCarrierId().getBranch());
            System.out.println("ADDRESS: " + c.getDestinationAddress());
            System.out.println("CARRIER ID-ClientID: " + c.getCarrierId().getClientId());
        });
    }

    @Test
    void findByTrackingId(){
        Carrier carrier = carrierRepository.findByTrackingId("8910-TX");
        System.out.println("CARRIER ID-BRANCH: " + carrier.getCarrierId().getBranch());
        System.out.println("ADDRESS: " + carrier.getDestinationAddress());
        System.out.println("CARRIER ID-ClientID: " + carrier.getCarrierId().getClientId());
    }

    @Test
    void findByCarrierLookupId(){
        LookupTable table = lookupTableRepository.findById(1234L).get();
        System.out.println("ABBREV: "+ table.getAbbreviation());
        System.out.println("DESCR: "+ table.getDescription());

        Carrier carrier = carrierRepository.findByCarrierLookupId(table);
        System.out.println("BRANCH: " + carrier.getCarrierId().getBranch());
        System.out.println("DEST ADDRESS: " + carrier.getDestinationAddress());
    }

    //---------------------------------------
    // *** Find By Multiple Attributes ***
    //---------------------------------------

}// CarrierRepositoryTest Class
