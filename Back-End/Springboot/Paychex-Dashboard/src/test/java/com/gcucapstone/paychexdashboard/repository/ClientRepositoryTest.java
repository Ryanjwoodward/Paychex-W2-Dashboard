package com.gcucapstone.paychexdashboard.repository;

import com.gcucapstone.paychexdashboard.entity.Client;
import com.gcucapstone.paychexdashboard.entity.LookupTable;
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
 * File:           | ClientRepositoryTest.java
 * Version:        | 1.0
 * Description:    | This file will be used to test the repo & query methods
 *                 |    defined within the ClientRepository interface
 * ---------------------------------------------------------------------------
 */
@SpringBootTest
public class ClientRepositoryTest {

    //-----------------------------------
    // Variables
    //-----------------------------------
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private LookupTableRepository lookupTableRepository;

    //----------------------------------------------------
    // Query Test Methods
    //----------------------------------------------------

    //--------------------------------
    // Find by Individual Attributes
    //--------------------------------

    @Test
    void findByW2TransmissionId(){

        Client client = clientRepository.findByW2TransmissionId("amazon-w2-id");

        System.out.println("BRANCH: " + client.getBranch());
        System.out.println("TRM ID: " + client.getW2TransmissionId());
    }

    @Test
    void findByBranch(){
        Client client = clientRepository.findByBranch("northwest");

        System.out.println("BRANCH: " + client.getBranch());
        System.out.println("TRM ID: " + client.getW2TransmissionId());
    }

    @Test
    void findByEmployeeCount(){
        List<Client> clients = clientRepository.findByEmployeeCount(1000);

        clients.forEach((c) -> {
            System.out.println("BRANCH: " + c.getBranch());
            System.out.println("EMP COUNT: " + c.getEmployeeCount());
            System.out.println("TRANS FILE: " + c.getTransmissionFile());
        });
    }

    @Test
    void findByTransmissionFile(){
        Client client = clientRepository.findByTransmissionFile("fedex-w2-files");
        System.out.println("BRANCH: " + client.getBranch());
        System.out.println("EMP COUNT: " + client.getEmployeeCount());
        System.out.println("TRANS FILE: " + client.getTransmissionFile());
    }

    @Test
    void  findByW2Count(){
        List<Client> clients = clientRepository.findByW2Count(1000);

        clients.forEach((c) -> {
            System.out.println("BRANCH: " + c.getBranch());
            System.out.println("EMP COUNT: " + c.getEmployeeCount());
            System.out.println("TRANS FILE: " + c.getTransmissionFile());
        });
    }

    @Test
    void findByW2DeliveryAddress(){
        List<Client> clients = clientRepository.findByW2DeliveryAddress("185 W Abschaum Ave");

        clients.forEach((c) -> {
            System.out.println("BRANCH: " + c.getBranch());
            System.out.println("EMP COUNT: " + c.getEmployeeCount());
            System.out.println("TRANS FILE: " + c.getTransmissionFile());
        });
    }

    @Test
    void findByClientTypeId(){
        LookupTable table = lookupTableRepository.findById(8910L).get();
        System.out.println("ABBREV: "+ table.getAbbreviation());
        System.out.println("DESCR: "+ table.getDescription());

        Client client = clientRepository.findByClientTypeId(table);
        System.out.println("BRANCH: " + client.getBranch());
        System.out.println("W2 COUNT: " + client.getW2Count());
    }

    @Test
    void findByDeliveryCodeTypeId(){
        LookupTable table = lookupTableRepository.findById(8910L).get();
        System.out.println("ABBREV: "+ table.getAbbreviation());
        System.out.println("DESCR: "+ table.getDescription());

        Client client = clientRepository.findByDeliveryCodeTypeId(table);
        System.out.println("BRANCH: " + client.getBranch());
        System.out.println("W2 COUNT: " + client.getW2Count());
    }


}// ClientRepositoryTest Class
