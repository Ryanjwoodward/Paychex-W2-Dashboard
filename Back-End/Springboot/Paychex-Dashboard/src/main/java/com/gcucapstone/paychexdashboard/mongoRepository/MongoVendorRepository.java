package com.gcucapstone.paychexdashboard.mongoRepository;

import com.gcucapstone.paychexdashboard.entity.BranchClient;
import com.gcucapstone.paychexdashboard.models.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-28-2022
 * File:           | MongoVendorRepository.java (mongo)
 * Version:        | 1.0
 * Description:    | This File will be used to write Query methods
 *  *              | for Mongo Vendor Documents
 * ---------------------------------------------------------------------------
 */
public interface MongoVendorRepository extends MongoRepository<Vendor, BranchClient> {

    //----------------------------------------------------
    // Query Methods
    //----------------------------------------------------


}// MongoVendorRepository Interface
