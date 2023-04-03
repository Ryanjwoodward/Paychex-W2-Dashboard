package com.gcucapstone.paychexdashboard.controller;

import com.gcucapstone.paychexdashboard.entity.Carrier;
import com.gcucapstone.paychexdashboard.entity.LookupTable;
import com.gcucapstone.paychexdashboard.entity.Vendor;
import com.gcucapstone.paychexdashboard.repository.LookupTableRepository;
import com.gcucapstone.paychexdashboard.repository.VendorRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    int[] attributeCounter = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    int currentSortAttrib = 0;
    int pageNumber;

    //----------------------------------------------------
    // Methods
    //----------------------------------------------------
    /**
     * Method to Return all Vendor records in the Database
     * @return
     */
    @GetMapping("/vendors")
    public List<Vendor> getAllVendors(){
        return vendorRepository.findAll();
    }



    /**
     * This method is a REST method that maps a GET operation to a VendorRepository
     * instance and calls it's extended JPARepository method findAll() and
     * returns a list of all Vendor records found in the schema
     * @return - a list of Vendor Records
     */
    @GetMapping("/vendors/{columnselect}")
    public List<Vendor> getAllVendors(@PathVariable(value = "columnselect") int selection){

            String[] attributes ={
                    "vendorId.clientId", "vendorId.branch", "employeeCount", "w2Count", "lookupId.lookupId",
                    "lookupId.abbreviation", "lookupId.description", "lookupId.fullName", "lookupId.state"
            };

            int pageSize = 5;

            Page<Vendor> vendorPage; // = vendorRepository.findAll(pageable);
            Sort sortby = Sort.by(attributes[0]).descending();

            switch(selection){
                case 1: //vendorId.clientId
                    if(attributeCounter[0] == 0) {
                        attributeCounter[0] = 1;
                        sortby = Sort.by(attributes[0]).descending();
                    }else{
                        attributeCounter[0] = 0;
                        sortby = Sort.by(attributes[0]).ascending();
                    }
                case 2://vendorId.branch
                    if(attributeCounter[1] == 0) {
                        attributeCounter[1] = 1;
                        sortby = Sort.by(attributes[1]).descending();
                    }else{
                        attributeCounter[1] = 0;
                        sortby = Sort.by(attributes[1]).ascending();
                    }
                case 3://employeeCount
                    if(attributeCounter[2] == 0) {
                        attributeCounter[2] = 1;
                        sortby = Sort.by(attributes[2]).descending();
                    }else{
                        attributeCounter[2] = 0;
                        sortby = Sort.by(attributes[2]).ascending();
                    }
                case 4://w2Count
                    if(attributeCounter[3] == 0) {
                        attributeCounter[3] = 1;
                        sortby = Sort.by(attributes[3]).descending();
                    }else{
                        attributeCounter[3] = 0;
                        sortby = Sort.by(attributes[3]).ascending();
                    }
                case 5://lookupId.lookupId
                    if(attributeCounter[4] == 0) {
                        attributeCounter[4] = 1;
                        sortby = Sort.by(attributes[4]).descending();
                    }else{
                        attributeCounter[4] = 0;
                        sortby = Sort.by(attributes[4]).ascending();
                    }
                case 6://lookupId.abbreviation
                    if(attributeCounter[5] == 0) {
                        attributeCounter[5] = 1;
                        sortby = Sort.by(attributes[5]).descending();
                    }else{
                        attributeCounter[5] = 0;
                        sortby =Sort.by(attributes[5]).ascending();
                    }
                case 7://lookupId.description
                    if(attributeCounter[6] == 0) {
                        attributeCounter[6] = 1;
                        sortby = Sort.by(attributes[6]).descending();
                    }else{
                        attributeCounter[6] = 0;
                        sortby = Sort.by(attributes[6]).ascending();
                    }
                case 8://lookupId.fullName
                    if(attributeCounter[7] == 0) {
                        attributeCounter[7] = 1;
                        sortby = Sort.by(attributes[7]).descending();
                    }else{
                        attributeCounter[7] = 0;
                        sortby = Sort.by(attributes[7]).ascending();
                    }
                    case 9: //lookupId.state
                        if(attributeCounter[8] == 0) {
                            attributeCounter[8] = 1;
                            sortby = Sort.by(attributes[8]).descending();
                        }else{
                            attributeCounter[8] = 0;
                            sortby = Sort.by(attributes[8]).ascending();
                        }
                default: //all vendors
                    // need a default page to return....
            }

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sortby);
        vendorPage = vendorRepository.findAll(pageable);
        List<Vendor> vendors = vendorPage.toList();
        return vendors;
    }

    @GetMapping("/pagevendors")
    private void incrementPageNumber() {
        if (this.pageNumber >= 2) {
            this.pageNumber = 0;
        } else {
            this.pageNumber += 1;
        }
    }

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
    public Vendor getVendorsByClientId(@PathVariable(value = "clientId") String clientId) {
        Vendor vendors = vendorRepository.findByClientId(clientId);
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

/*








 */