package com.gcucapstone.paychexdashboard.mongoRepository;

import com.gcucapstone.paychexdashboard.models.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**-------------------------------------------------------------------
 *  Authors:      | Ryan Woodward
 *  Class:        | STG451 - Capstone 1
 *  Institution:  | Grand Canyon University &  Paychex
 *  Instructor:   | Dr. Isac Artzi
 *  Date:         | (created) 10-29-2022
 *  File:         | MongoClientRepositoryTest.java (mongo)
 *  Version:      | 1.0
 *  Description:  | This class will be used to test query methods
 *                | in the Mongo Repository interface ClientRepository
 *---------------------------------------------------------------------
 Notes:

 *----------------------------------------------------------------------*/
@SpringBootTest
public class MongoClientRepositoryTest {

    //----------------------------------------------------
    // Instance Variables
    //----------------------------------------------------

    @Autowired
    private MongoClientRepository clientRepository;

    //----------------------------------------------------
    // Query Methods Tests
    //----------------------------------------------------

    @Test
    void saveCLientDoc(){
        clientRepository.save(new Client());

    }
    @Test
    void findAllCLients(){
        clientRepository.findAll().forEach((c) -> {
            System.out.println("BRANCH: " + c.getBranch());
            System.out.println("W2DA: " + c.getW2DeliveryAddress());
        });
    }

}// MongoClientRepositoryTest Class
