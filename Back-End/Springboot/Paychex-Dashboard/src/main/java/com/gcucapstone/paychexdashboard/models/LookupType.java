package com.gcucapstone.paychexdashboard.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-28-2022
 * File:           | LookupType,java
 * Version:        | 1.0
 * Description:    | This File will be used to Map LookupType Models &
 *                 | Documents from the PaychexDashboard Mongo Database
 * ---------------------------------------------------------------------------
 */
@Data
@Document(collection = "LookupType")
public class LookupType {

    //----------------------------------------------------
    // Instance Variables
    //----------------------------------------------------
    @Id
    private Long lookupTypeId;

    private String lookupType;

}//LookupType Class
