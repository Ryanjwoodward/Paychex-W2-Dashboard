package com.gcucapstone.paychexdashboard.mongoRepository;

import com.gcucapstone.paychexdashboard.models.LookupTable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-28-2022
 * File:           | MongoLookupTableRepository.java (mongo)
 * Version:        | 1.0
 * Description:    | This File will be used to write Query methods
 *  *              | for Mongo LookupTable Documents
 * ---------------------------------------------------------------------------
 */
public interface MongoLookupTableRepository extends MongoRepository<LookupTable, Long> {

    //----------------------------------------------------
    // Query Methods
    //----------------------------------------------------

}// MongoLookupTableRepository Interface
