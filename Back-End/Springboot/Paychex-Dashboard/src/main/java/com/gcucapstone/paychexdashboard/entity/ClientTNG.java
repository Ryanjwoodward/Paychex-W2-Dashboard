package com.gcucapstone.paychexdashboard.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created) 10-13-2022
 * File:           | w2ClientTNG.java
 * Version:        | 1.0
 * Description:    | This class represents the w2_client_tng table/entity in the paychex dashboard DB.
 * |               | It will be used to create client_tng entities and determine relationship between
 *                 | tables using the fields/attributes
 * ---------------------------------------------------------------------------
 Notes:

 ----------------------------------------------------------------------*/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(
        name = "w2_client_tng",
        schema = "PaychexDashboard"
)
public class ClientTNG {

    //----------------------------------------------------
    // Instance Variables
    //----------------------------------------------------
    @Id
    @Column(name = "w2_transmission_id")
    private String w2TransmissionId;

    @Column(name = "branch")
    private String branch;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name = "tng_employee_count")
    private int tngEmployeeCount;

    @Column(name = "transmission_file")
    private String transmissionFile;

    @Column(name = "tng_w2_count")
    private int tngW2Count;

    @Column(name = "w2_dlivery_address")
    private String w2DeliveryAddress;

    @OneToOne
    @JoinColumn(name = "client_type_id", referencedColumnName = "lookup_id")
    private LookupTable clientTypeId;

    @OneToOne
    @JoinColumn(name = "delivery_code_type", referencedColumnName = "lookup_id")
    private LookupTable deliveryCodeType;

}// w2ClientTNG Class
