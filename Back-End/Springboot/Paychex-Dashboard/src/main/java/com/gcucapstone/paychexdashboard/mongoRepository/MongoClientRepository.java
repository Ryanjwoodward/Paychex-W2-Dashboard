package com.gcucapstone.paychexdashboard.mongoRepository;

import com.gcucapstone.paychexdashboard.models.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-28-2022
 * File:           | MongoClientRepository.java (mongo)
 * Version:        | 1.0
 * Description:    | This File will be used to write Query methods
 *  *              | for Mongo Client Documents
 * ---------------------------------------------------------------------------
 */
public interface MongoClientRepository extends MongoRepository<Client, String> {

    //----------------------------------------------------
    // Query Methods
    //----------------------------------------------------

}// MongoClientRepository Interface
