package com.gcucapstone.paychexdashboard.controller;

import com.gcucapstone.paychexdashboard.entity.Carrier;
import com.gcucapstone.paychexdashboard.entity.LookupTable;
import com.gcucapstone.paychexdashboard.repository.CarrierRepository;
import com.gcucapstone.paychexdashboard.repository.LookupTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward & Chris Robles
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-28-2022
 * File:           | CarrierController.java
 * Version:        | 1.0
 * Description:    | This file will be used to create REST API's for
 *                 | Carrier entities such as basic CRUD methods
 * ---------------------------------------------------------------------------
 * Notes:
 *  - add Get method for Greater/Less Than Employee count and w2 count
 *      ^ (above) requires writing those methods in the repo class first
 *--------------------------------------------------------------------------*/
@RestController
@CrossOrigin(origins = "http://localhost:3306")
@RequestMapping("/dashboard/carrier")
public class CarrierController {

    //----------------------------------------------------
    // Class Variables
    //----------------------------------------------------

    @Autowired
    private CarrierRepository carrierRepository;

    @Autowired
    private LookupTableRepository lookupTableRepository;

    //----------------------------------------------------
    // Methods
    //----------------------------------------------------

    /**
     * This REST method maps a GET request to a MongoCarrierRepository instance
     * and calls it's extended JPARepository method findAll() and returns
     * a list of all Carrier Records found in the schema
     * @return  - a list of Carrier Records
     */
    @GetMapping("/carriers")
    public List<Carrier> getAllCarriers(){ return carrierRepository.findAll();}

    /**
     * This REST method maps a GET request to a MongoCarrierRepository instance
     * and calls the JPA Named Query Method findByBranch() and returns a
     * list of Carrier records with a branch attribute that matche the
     * passed parameter
     * @param branch    - the branch to search for
     * @return          - list of Carrier records
     */
    @GetMapping("/branch/{branch}")
    public List<Carrier> getCarriersByBranch(@PathVariable(value = "branch") String branch){
        List<Carrier> carriers = carrierRepository.findByBranch(branch);
        return carriers;
    }

    /**
     * This REST method maps a GET request to a MongoCarrierRepository instance
     * and calls the JPA Named Query Method findByBranch() and returns a list
     * of Carrier records with a clientId attribute that matches the
     * passed parameter
     * @param clientId  - the clientId to search for
     * @return          - list of Carrier records
     */
    @GetMapping("/clientid/{clientid}")
    public List<Carrier> getCarriersByClientId(@PathVariable(value = "clientid") String clientId){
        List<Carrier> carriers = carrierRepository.findByClientId(clientId);
        return carriers;
    }

    /**
     * This REST method maps a GET request to a MongoCarrierRepository instance
     * and calls the JPA Name Query Method findByDestinationAddress() and
     * returns a list of Carrier Records with a destinationAddress attribute
     * that match the passed parameter
     * @param destinationAddress    - the destinationAddress to search for
     * @return                      - list of Carrier Records
     */
    @GetMapping("/destaddress/{destaddress}")
    public List<Carrier> getCarriersByDestinationAddress(@PathVariable(value = "destaddress")String destinationAddress){
        List<Carrier> carriers = carrierRepository.findByDestinationAddress(destinationAddress);
        return carriers;
    }

    /**
     * This REST method maps a GET request to a MongoCarrierRepository instance
     * and calls the JPA Name Query Method findByTrackingId() and
     * returns a list of Carrier Records with a TrackingId attribute
     * that match the passed parameter
     * @param trackingId    - the trackingId to search for
     * @return              - the Carrier record
     */
    @GetMapping("/trackingid/{trackingid}")
    public Carrier getCarrierByTrackingId(@PathVariable(value = "trackingid") String trackingId){
        Carrier carrier = carrierRepository.findByTrackingId(trackingId);
        return carrier;
    }

    /**
     * This REST method maps a GET request to a MongoCarrierRepository instance
     * and calls the JPA Name Query Method findByCarrierLookupId() and
     * returns a list of Carrier Records with a LookupId attribute
     * that match the passed parameter
     * @param id   - the lookup id to search for
     * @return     - the Carrier record
     */
    @GetMapping("/lookupid/{idl}")
    public Carrier getCarrierByLookipId(@PathVariable(value = "idl")Long id){
        LookupTable table = lookupTableRepository.findByLookupId(id);
        Carrier carrier = carrierRepository.findByCarrierLookupId(table);
        return carrier;
    }

}// CarrierController Class
