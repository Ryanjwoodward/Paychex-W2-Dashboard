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
 * File:           | Carrier.java
 * Version:        | 1.0
 * Description:    | This File will be used to Map Carrier Models &
 *                 | Documents from the PaychexDashboard Mongo Database
 * ---------------------------------------------------------------------------
 */
@Data
@Document(collection = "Carrier")
public class Carrier {

    //----------------------------------------------------
    // Instance Variables
    //----------------------------------------------------
    @Id
    private BranchClient carrierId;

    private String destinationAddress;

    private String trackingId;

    private com.gcucapstone.paychexdashboard.entity.LookupTable carrierLookupId;

    private LookupTable deliveryStatusTypeId;


}//Carrier Class
