package com.gcucapstone.paychexdashboard.controller;


import com.gcucapstone.paychexdashboard.entity.Client;
import com.gcucapstone.paychexdashboard.entity.LookupTable;
import com.gcucapstone.paychexdashboard.repository.ClientRepository;
import com.gcucapstone.paychexdashboard.repository.LookupTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-28-2022
 * File:           | ClientController.java
 * Version:        | 1.0
 * Description:    | This file will be used to create REST API's for Client
 *                 | entities such as basic CRUD methods
 * ---------------------------------------------------------------------------
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/dashboard/client")
public class ClientController {

    //----------------------------------------------------
    // Class Variables
    //----------------------------------------------------
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private LookupTableRepository lookupTableRepository;

    //----------------------------------------------------
    // Methods
    //----------------------------------------------------

    /**
     * This REST method maps a GET request to a ClientRepository instance
     * and calls it's extended JPARepository method findAll() and returns
     * a list of all Client Records found in the schema
     * @return  - a list of Client Records
     */
    @GetMapping("/clients")
    public List<Client> getAllClients(){ return clientRepository.findAll(); }


    /**
     * This REST method maps a GET request toa ClientRepository instance and calls
     * a JPA Named Query Method findByW2TransmissionId() and returns a Client
     * record that has an attribute of w2TransmissionId that matches the passed
     * parameter
     * @param transmissionId    - the transmissionId to search for
     * @return                  - the Client Record
     */
    @GetMapping("/transmissionid/{wtid}")
    public Client getClientByTransmissionId(@PathVariable(value = "wtid") String transmissionId){
        Client client = clientRepository.findByW2TransmissionId(transmissionId);
        return client;
    }

    /**
     * This REST method maps a GET request toa ClientRepository instance and calls
     * a JPA Named Query Method findByBranch() and returns a Client
     * record that has an attribute of branch that matches the passed parameter
     * @param branch   - the branch to search for
     * @return         - the Client Record
     */
    @GetMapping("/branch/{branch}")
    public Client getClientByBranch(@PathVariable(value = "branch") String branch){
        Client client = clientRepository.findByBranch(branch);
        return client;
    }

    /**
     * This REST method maps a GET a request to a ClientRepository instance and calls
     * a JPA Named Query method findByEmployeeCount() and returns a clist of
     * Client records that have an attribute of EmployeeCOunt that match the passed parameter
     * @param employeeCount - the employee count to search for
     * @return              - the list of client records
     */
    @GetMapping("/empcount/{empcount}")
    public List<Client> getClientsByEmployeeCount(@PathVariable(value = "empcount") int employeeCount){
        List<Client> clients = clientRepository.findByEmployeeCount(employeeCount);
        return clients;
    }

    /**
     * This REST method maps a GET request to a ClientRepository instance and calls
     * a JPA Named Query method: findByTransmissionFile() and returns a Client recod
     * that has an attribute of TransmissionFile that matches the passed Parameter
     * @param transmissionFile  - the transmission file to search for
     * @return                  - the Client record
     */
    @GetMapping("/transmissionfile/{transfile}")
    public Client getClientByTransmissionFile(@PathVariable(value = "transfile") String transmissionFile){
        Client client = clientRepository.findByTransmissionFile(transmissionFile);
        return client;
    }

    /**
     * This REST method maps a GET request to a ClientRepository instance and calls
     * a JPA Named Query method: findByW2Count() and returns a list of Client records
     * that has an attribute of TransmissionFile that matches the passed Parameter
     * @param w2Count  - the w2 count to search for
     * @return         - the Client records
     */
    @GetMapping("/w2count/{w2count}")
    public List<Client> getClientsByW2Count(@PathVariable(value = "w2count") int w2Count){
        List<Client> clients = clientRepository.findByW2Count(w2Count);
        return clients;
    }

    /**
     * This REST method maps a GET request to a ClientRepository instance and calls
     * a JPA Named Query method: findByW2DeliveryAddress() and returns a list of Client records
     * that has an attribute of w2DeliveryAddress that matches the passed Parameter
     * @param w2DeliveryAddress  - the w2DeliveryAddress to search for
     * @return                   - the Client records
     */
    @GetMapping("w2address/{w2deladdress}")
    public List<Client> getClientsByW2DeliveryAddress(@PathVariable(value = "w2deladdress")String w2DeliveryAddress){
        List<Client> clients = clientRepository.findByW2DeliveryAddress(w2DeliveryAddress);
        return clients;
    }

    /**
     * This REST method maps a GET request to a ClientRepository instance and calls
     * a JPA Named Query method: findByClientTypeId() and returns a Client record
     * that has an attribute of lookupid that matches the passed parameter
     * @param id    - the lookup id to search for
     * @return      - the Client record
     */
    @GetMapping("/clienttypeid/{tableid}")
    public Client getClientByClientTypeId(@PathVariable(value = "tableid")Long id){
        LookupTable table = lookupTableRepository.findByLookupId(id);
        Client client  = clientRepository.findByClientTypeId(table);
        return client;
    }

    /**
     * This REST method maps a GET request to a ClientRepository instance and calls
     * a JPA Named Query method: findByDeliveryCodeIf() and returns a Client record
     * that has an attribute of lookupid that matches the passed parameter
     * @param id    - the lookup id to search for
     * @return      - the Client record
     */
    @GetMapping("/deliverycodeid/{tableid}")
    public Client getClientByDeliveryCodeId(@PathVariable(value = "tableid")Long id){
        LookupTable table = lookupTableRepository.findByLookupId(id);
        Client client = clientRepository.findByDeliveryCodeTypeId(table);
        return client;
    }


}//ClientController Class
