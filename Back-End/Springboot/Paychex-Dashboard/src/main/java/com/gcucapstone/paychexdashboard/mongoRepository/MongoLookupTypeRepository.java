package com.gcucapstone.paychexdashboard.mongoRepository;

import com.gcucapstone.paychexdashboard.models.LookupType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-28-2022
 * File:           | MongoLookupTypeRepository.java (mongo)
 * Version:        | 1.0
 * Description:    | This File will be used to write Query methods
 *  *              | for Mongo LookupType Documents
 * ---------------------------------------------------------------------------
 */
public interface MongoLookupTypeRepository extends MongoRepository<LookupType, Long> {

    //----------------------------------------------------
    // Query Methods
    //----------------------------------------------------



}// MongoLookupTypeRepository Interface
