package com.gcucapstone.paychexdashboard.models;

import com.gcucapstone.paychexdashboard.entity.BranchClient;
import com.gcucapstone.paychexdashboard.entity.LookupTable;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-28-2022
 * File:           | Vendor.java
 * Version:        | 1.0
 * Description:    | This File will be used to Map Vendor Models &
 *                 | Documents from the PaychexDashboard Mongo Database
 * ---------------------------------------------------------------------------
 */
@Data
@Document(collection = "Vendor")
public class Vendor {

    //----------------------------------------------------
    // Instance Variables
    //----------------------------------------------------
    @Id
    private BranchClient vendorId;

    private int employeeCount;

    private int w2Count;

    private LookupTable lookupId;

}//Vendor Class
