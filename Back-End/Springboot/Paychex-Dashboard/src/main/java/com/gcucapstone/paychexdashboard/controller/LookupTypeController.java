package com.gcucapstone.paychexdashboard.controller;

import com.gcucapstone.paychexdashboard.entity.LookupType;
import com.gcucapstone.paychexdashboard.repository.LookupTypeRepository;
import exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-26-2022
 * File:           | LookupTypeController.java
 * Version:        | 1.0
 * Description:    | This file will be used to create REST API's for
 *                 | LookupType Entities such as the basic CRUD methods
 * ---------------------------------------------------------------------------
 */
@RestController @CrossOrigin(origins = "http://localhost:3306")
@RequestMapping("/dashboard/lookuptype")
public class LookupTypeController {

    //----------------------------------------------------
    // Instance Variables
    //----------------------------------------------------
    @Autowired
    private LookupTypeRepository lookupTypeRepository;


    //----------------------------------------------------
    // Methods
    //----------------------------------------------------

    /**
     * This method is a REST method that maps a GET operation to lookupTypRepository
     * instance and calls extended JPArepository method findAll() and
     * returns a list of LookupType records
     * @return  - list of lookupType records
     */
    @GetMapping("/lookuptypes")
    public List<LookupType> getAllLookupTypes(){
        return lookupTypeRepository.findAll();
    }

    @GetMapping("/lookuptypes/{id}")
    public ResponseEntity<LookupType> getLookUpTypeById(@PathVariable(value = "id") Long lookupTypeId) throws ResourceNotFoundException{
        LookupType lookupType = lookupTypeRepository.findById(lookupTypeId).orElseThrow(() -> new ResourceNotFoundException("Nothing Found for this ID"));
        return ResponseEntity.ok().body(lookupType);
    }
}// LookupTypeController Class
