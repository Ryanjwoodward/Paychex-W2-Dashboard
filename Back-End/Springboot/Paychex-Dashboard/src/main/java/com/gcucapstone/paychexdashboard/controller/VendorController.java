package com.gcucapstone.paychexdashboard.controller;

import com.gcucapstone.paychexdashboard.entity.LookupTable;
import com.gcucapstone.paychexdashboard.entity.Vendor;
import com.gcucapstone.paychexdashboard.repository.LookupTableRepository;
import com.gcucapstone.paychexdashboard.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward & Chris Robles
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-28-2022
 * File:           | VendorController.java
 * Version:        | 1.0
 * Description:    | This file will be used to create REST API's for Vendor
 *                 | entities such as the basic CRUD methods.
 * ---------------------------------------------------------------------------
 * Notes:
 *  - Add Get methods for GreaterThan/LessThan w2 & Employee Count methods
 *---------------------------------------------------------------------------*/
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/dashboard/vendor")
public class VendorController {

    //----------------------------------------------------
    // Class Variables
    //----------------------------------------------------
    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private LookupTableRepository lookupTableRepository;

    //----------------------------------------------------
    // Methods
    //----------------------------------------------------

    /**
     * This method is a REST method that maps a GET operation to a VendorRepository
     * instance and calls it's extended JPARepository method findAll() and
     * returns a list of all Vendor records found in the schema
     * @return - a list of Vendor Records
     */
    @GetMapping("/vendors")
    public List<Vendor> getAllVendors(){ return vendorRepository.findAll();}

    /**
     * This is a REST method that maps a GET operation to a VendorRepository instance
     * and calls the JPA Named Query Method findByBranch() and returns a list of
     * vendor records with a branch attribute that match the passed parameter
     * @param branch    - the branch to search for
     * @return          - a list of Vendor records
     */
    @GetMapping("/branch/{branch}")
    public List<Vendor> getVendorsByBranch(@PathVariable(value = "branch") String branch){
        List<Vendor> vendors = vendorRepository.findByBranch(branch);
        return vendors;
    }

    /**
     * This is a REST method that maps a GET operation to a VendorRepository instance
     * and calls the JPA Named Query Method findByClientId() and returns a list of
     * vendor records with a clientId attribute that match the passed parameter
     * @param clientId  - the clientId to search for
     * @return          - a list of Vendor records
     */
    @GetMapping("/clientid/{clientId}")
    public List<Vendor> getVendorsByClientId(@PathVariable(value = "clientId") String clientId) {
        List<Vendor> vendors = vendorRepository.findByClientId(clientId);
        return vendors;
    }

    /**
     * This is a REST metod that maps a GET operation to a VendorRepository instance
     * and calls the JPA Named Query Method findByEmployeeCount() and returns a list
     * of Vendor records with an employeeCount attribute that match the passed parameter
     * @param employeeCount - the employee count to search for
     * @return              - list of Vendor records
     */
    @GetMapping("/employeecount/{empCount}")
    public List<Vendor> getVendorsByEmployeeCount(@PathVariable(value = "empCount")int employeeCount){
        List<Vendor> vendors = vendorRepository.findByEmployeeCount(employeeCount);
        return vendors;
    }

    /**
     * This is a REST method that maps a GET request to a VendorRepository instance
     * and calls the JPA Named Query method findByW2Count() and in response returns
     * a list of Vendor records with a W2Count attribute that match the passed parameter
     * @param w2Count   - the w2 count to search for
     * @return          - list of vendor records
     */
    @GetMapping("/w2count/{w2Count}")
    public List<Vendor> getVendorsByW2Count(@PathVariable(value = "w2Count") int w2Count) {
        List<Vendor> vendors = vendorRepository.findByW2Count(w2Count);
        return vendors;
    }

    /**
     * This is a REST method that maps a GET request to a VendorRepository and
     * LookupTableRepository instances and calls two JPA Named Query methods and
     * in reponse returns a Vendor records that has a lookupId that matches the
     * passed parameter
     * @param id    - the lookupId to search for
     * @return      - vendor record
     */
    @GetMapping("/lookupid/{tableid}")
    public Vendor getVendorByLookupId(@PathVariable(value = "tableid") Long id) {
        LookupTable table = lookupTableRepository.findByLookupId(id);
        Vendor vendor = vendorRepository.findByLookupId(table);
        return vendor;
    }

    /**
     * This is REST method that maps a GET Request to a Vendor Repository instance
     * and returns a list of Vendor records that have a state attribute that match the
     * passed string argument
     * @param state     - the passed argument
     * @return          - the List of Vendor Records
     */
    @GetMapping("/lookuptable/{state}")
    public List<Vendor> getVendorsByState(@PathVariable(value = "state")String state){
        List<Vendor> vendors = vendorRepository.findByLookupTableState(state);
        return vendors;
    }

}//VendorController Class
