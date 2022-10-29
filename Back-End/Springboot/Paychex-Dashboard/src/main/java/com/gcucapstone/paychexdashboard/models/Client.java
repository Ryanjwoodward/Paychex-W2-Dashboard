package com.gcucapstone.paychexdashboard.models;

import com.gcucapstone.paychexdashboard.models.LookupTable;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-28-2022
 * File:           | Client.java
 * Version:        | 1.0
 * Description:    | This File will be used to Map Client Models &
 *                 | Documents from the PaychexDashboard Mongo Database
 * ---------------------------------------------------------------------------
 */
@Data
@Document(collection = "Client")
public class Client {

    //----------------------------------------------------
    // Instance Variables
    //----------------------------------------------------

    @Id
    private String w2TransmissionId;

    private String branch;

    private Timestamp createdDate;

    private int employeeCount;

    private String transmissionFile;

    private int w2Count;

    private String w2DeliveryAddress;

    private LookupTable clientTypeId;

    private LookupTable deliveryCodeTypeId;

}//Client Class
