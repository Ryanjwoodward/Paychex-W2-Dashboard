package com.gcucapstone.paychexdashboard.controller;

import com.gcucapstone.paychexdashboard.entity.Carrier;
import com.gcucapstone.paychexdashboard.entity.LookupTable;
import com.gcucapstone.paychexdashboard.repository.CarrierRepository;
import com.gcucapstone.paychexdashboard.repository.LookupTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/dashboard/carrier")
public class CarrierController {

    //----------------------------------------------------
    // Class Variables
    //----------------------------------------------------

    @Autowired
    private CarrierRepository carrierRepository;

    @Autowired
    private LookupTableRepository lookupTableRepository;

    int[] attributeCounter = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    //----------------------------------------------------
    // Methods
    //----------------------------------------------------

    /**
     * This REST method maps a GET request to a MongoCarrierRepository instance
     * and calls it's extended JPARepository method findAll() and returns
     * a list of all Carrier Records found in the schema
     * @return  - a list of Carrier Records
     */
    @GetMapping("/carriers/{sel}")
    public List<Carrier> getAllCarriers(@PathVariable(value = "sel") int selection){

        String[] attributes ={
                "carrierId.clientId", "carrierId.branch", "destinationAddress", "trackingId", "carrierLookupId.lookupId",
                "carrierLookupId.abbreviation", "carrierLookupId.description", "carrierLookupId.fullName", "carrierLookupId.state"
        };

        switch(selection){
            case 1: //vendorId.clientId
                if(attributeCounter[0] == 0) {
                    attributeCounter[0] = 1;
                    return carrierRepository.findAll(Sort.by(attributes[0]).descending());
                }else{
                    attributeCounter[0] = 0;
                    return carrierRepository.findAll(Sort.by(attributes[0]).ascending());
                }
            case 2://vendorId.branch
                if(attributeCounter[1] == 0) {
                    attributeCounter[1] = 1;
                    return carrierRepository.findAll(Sort.by(attributes[1]).descending());
                }else{
                    attributeCounter[1] = 0;
                    return carrierRepository.findAll(Sort.by(attributes[1]).ascending());
                }
            case 3://employeeCount
                if(attributeCounter[2] == 0) {
                    attributeCounter[2] = 1;
                    return carrierRepository.findAll(Sort.by(attributes[2]).descending());
                }else{
                    attributeCounter[2] = 0;
                    return carrierRepository.findAll(Sort.by(attributes[2]).ascending());
                }
            case 4://w2Count
                if(attributeCounter[3] == 0) {
                    attributeCounter[3] = 1;
                    return carrierRepository.findAll(Sort.by(attributes[3]).descending());
                }else{
                    attributeCounter[3] = 0;
                    return carrierRepository.findAll(Sort.by(attributes[3]).ascending());
                }
            case 5://lookupId.lookupId
                if(attributeCounter[4] == 0) {
                    attributeCounter[4] = 1;
                    return carrierRepository.findAll(Sort.by(attributes[4]).descending());
                }else{
                    attributeCounter[4] = 0;
                    return carrierRepository.findAll(Sort.by(attributes[4]).ascending());
                }
            case 6://lookupId.abbreviation
                if(attributeCounter[5] == 0) {
                    attributeCounter[5] = 1;
                    return carrierRepository.findAll(Sort.by(attributes[5]).descending());
                }else{
                    attributeCounter[5] = 0;
                    return carrierRepository.findAll(Sort.by(attributes[5]).ascending());
                }
            case 7://lookupId.description
                if(attributeCounter[6] == 0) {
                    attributeCounter[6] = 1;
                    return carrierRepository.findAll(Sort.by(attributes[2]).descending());
                }else{
                    attributeCounter[6] = 0;
                    return carrierRepository.findAll(Sort.by(attributes[2]).ascending());
                }
            case 8://lookupId.fullName
                if(attributeCounter[7] == 0) {
                    attributeCounter[7] = 1;
                    return carrierRepository.findAll(Sort.by(attributes[7]).descending());
                }else{
                    attributeCounter[7] = 0;
                    return carrierRepository.findAll(Sort.by(attributes[7]).ascending());
                }                case 9: //lookupId.state
            default: //all vendors
                return carrierRepository.findAll();
        }
    }

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
    public Carrier getCarriersByClientId(@PathVariable(value = "clientid") String clientId){
        Carrier carriers = carrierRepository.findByClientId(clientId);
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

    /**
     * This is REST method that maps a GET Request to a CarrierRepository Instance
     * and returns a List of Carrier records that have a state attribute (of their
     * LookupTable FK attribute) that matches the passed argument
     * @param state - the passed argument
     * @return      - List of Carrier Records
     */
    @GetMapping("/lookuptable/{state}")
    public List<Carrier> getCarriersByState(@PathVariable(value = "state")String state){
        List<Carrier> carriers = carrierRepository.findByLookupTableState(state);
        return carriers;
    }



}// CarrierController Class
