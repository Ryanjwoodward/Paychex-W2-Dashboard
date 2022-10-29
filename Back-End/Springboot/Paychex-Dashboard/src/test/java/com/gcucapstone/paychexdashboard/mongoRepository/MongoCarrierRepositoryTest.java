package com.gcucapstone.paychexdashboard.mongoRepository;

import com.gcucapstone.paychexdashboard.models.Carrier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**-------------------------------------------------------------------
 *  Authors:      | Ryan Woodward
 *  Class:        | STG451 - Capstone 1
 *  Institution:  | Grand Canyon University &  Paychex
 *  Instructor:   | Dr. Isac Artzi
 *  Date:         | (created) 10-29-2022
 *  File:         | MongoCarrierRepositoryTest.java (mongo)
 *  Version:      | 1.0
 *  Description:  | This class will be used to test query methods
 *                | in the Mongo Repository interface CarrierRepository
 *---------------------------------------------------------------------
 Notes:

 *----------------------------------------------------------------------*/
@SpringBootTest
public class MongoCarrierRepositoryTest {

    //----------------------------------------------------
    // Instance Variables
    //----------------------------------------------------

    @Autowired
    private MongoCarrierRepository carrierRepository;

    //----------------------------------------------------
    // Query Methods Tests
    //----------------------------------------------------

    @Test
    void saveCarrierDoc(){
        carrierRepository.save(new Carrier());
    }


    @Test
    void findAllCarriers(){
        carrierRepository.findAll().forEach((c) ->{
            System.out.println("DEST ADDR : " + c.getDestinationAddress());
            System.out.println("TRACK ID: " + c.getTrackingId());
            System.out.println("CLIENT ID: " + c.getCarrierId().getClientId());
            System.out.println("BRANCH: " + c.getCarrierId().getBranch());
        });
    }

}// MongoCarrierRepositoryTest Class
