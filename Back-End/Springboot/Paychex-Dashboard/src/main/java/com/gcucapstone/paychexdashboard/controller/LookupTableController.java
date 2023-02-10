package com.gcucapstone.paychexdashboard.controller;

import com.gcucapstone.paychexdashboard.entity.LookupTable;
import com.gcucapstone.paychexdashboard.entity.LookupType;
import com.gcucapstone.paychexdashboard.repository.LookupTableRepository;
import com.gcucapstone.paychexdashboard.repository.LookupTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward & Chris Robles
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr.Isac Artzi
 * Date:           | (Created)10-27-2022
 * File:           | LookupTableCOntroller.java
 * Version:        | 1.0
 * Description:    | This file will be used to create REST API's for
 *                 | lookupTable Entities such as the basic CRUD methods
 * ---------------------------------------------------------------------------
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/dashboard/lookuptable")
public class LookupTableController {

    //----------------------------------------------------
    // Instance Variables
    //----------------------------------------------------
    @Autowired
    private LookupTableRepository lookupTableRepository;

    @Autowired
    private LookupTypeRepository lookupTypeRepository;

    //----------------------------------------------------
    // Methods
    //----------------------------------------------------

    /**
     * This method is a REST method that maps a GET operation to a lookupTableRepository
     * instance and calls it's extended JPARepository method findAll() and
     * returns a list of all LookupTable records found in the schema
     * @return  - list of lookupTable records
     */
    @GetMapping("/lookuptables")
    public List<LookupTable> getAllLookupTables(){
        return lookupTableRepository.findAll();
    }

    /**
     * This REST method maps a GET Request to a lookupTableRepository instance
     * and calls the JPA Named QUery method: findByLookupId defined in
     * lookupTableRepository and as a response to a server request returns
     * a list of LookupTable Records that have an attribute of lookupId
     * that matches the passed parameter
     * @param tableId   - the lookupTable id to search for
     * @return          - the LookupTable Record
     */
    @GetMapping("/tableid/{id}")
    public LookupTable getLookupTableById(@PathVariable(value = "id") Long tableId){
        LookupTable lookupTable = lookupTableRepository.findByLookupId(tableId);
        return lookupTable;
    }

    /**
     * This REST method maps a GET request to a lookupTableRepository instance
     * and calls the JPA Named Query Method: findByAbbreviation defined
     * in the LookupTableRepository and as a response to a server request
     * returns a list of lookupTable records that have an abbreviation
     * attribute that match the passed parameter
     * @param abbreviation  - the abbreviation to search for
     * @return              - the list of LookupTable records
     */
    @GetMapping("/abbreviation/{abbreviation}")
    public List<LookupTable> getLookupTableByAbbreviation(@PathVariable(value = "abbreviation") String abbreviation){
        List<LookupTable> lookupTables = lookupTableRepository.findByAbbreviation(abbreviation);
        return lookupTables;
    }

    /**
     * This REST method maps a GET request to a lookupTableRepository instance
     * and calls the JPA Named Query method: findByDescription defined in
     * LookupTableRepository and as a response to a server request returns a list
     * of lookupTable records that have a description attribute that match
     * the passed parameter.
     * @param description   - the description to search for
     * @return              - the list of lookuptable records
     */
    @GetMapping("/description/{description}")
    public List<LookupTable> getLookupTableByDescription(@PathVariable(value = "description") String description){
        List<LookupTable> lookupTables = lookupTableRepository.findByDescription(description);
        return lookupTables;
    }

    /**
     * This REST method maps a GET request to a LookupTableRepository instance
     * and calls the JPA Named Query Method: findByFullName and as a response to a
     * server request returns a list of lookupTable records that have a fullname
     * attribute that match the passed parameter.
     * @param fullName  - fullName to search for
     * @return          - list of lookupTable Records
     */
    @GetMapping("/fullname/{fullname}")
    public List<LookupTable> getLookupTableByFullName(@PathVariable(value = "fullname") String fullName){
        List<LookupTable> lookupTables = lookupTableRepository.findByFullName(fullName);
        return lookupTables;
    }

    /**
     * This REST method maps a GET Request to a lookupTableRepository instance
     * lookupTypeRepository instance. The passed parameter is used to locate a lookupType Record,
     * which serves as the TypeID of a lookupTable when the JPA named Query method findByLookupTypeId
     * is called. In response to the request this method return a LookupTable Record that possess
     * an attribute that corresponds the LookupTypeId - typeid field
     * @param typeid    - the LookupType Id that corresponds to the LookupTable Record
     * @return          - lookupTable record
     */
    @GetMapping("/lookuptype/{idL}")
    public LookupTable getLookupTableByLookupTypeId(@PathVariable(value = "idL")Long typeid){
        LookupType type = lookupTypeRepository.findByLookupTypeId(typeid);
        if(type == null) return null;
        LookupTable table = lookupTableRepository.findByLookupTypeId(type);
        return table;
    }


    /**
     * This REST method maps a GET Reqeuest to a LookupTable Instance. This method is called to fetch all
     * LookupTable enities in the SQL database and sort them, in ascending order, by their state attribute
     * @return  - the List of all LookupTables in ascending order (state)
     */
    @GetMapping("/sortby/stateasc")
    public List<LookupTable> getAllLookupTablesSortedByStateAsc(){

        List<LookupTable> sortedTables = lookupTableRepository.findAll(Sort.by("state").ascending());
        return sortedTables;
    }


    /**
     * This REST method maps a GET Reqeuest to a LookupTable Instance. This method is called to fetch all
     * LookupTable enities in the SQL database and sort them, in descending order, by their state attribute
     * @return  - the List of all LookupTables in descending order (state)
     */
    @GetMapping("/sortby/statedesc")
    public List<LookupTable> getAllLookupTablesSortedByStateDesc(){

        List<LookupTable> sortedTables = lookupTableRepository.findAll(Sort.by("state").descending());
        return sortedTables;
    }

    @GetMapping("/tables/{state}")
    public List<LookupTable> getLookupTablesByState(@PathVariable(value = "state")String state){

        List<LookupTable> tables = lookupTableRepository.findByState(state);
        return tables;
    }


}//LookupTableController Class
