package com.gcucapstone.paychexdashboard.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    - Add Foreign Key Relationship annotations to two latter columns
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

    // Add FK relationsip annotation
    @Column(name = "client_type_id")
    private int clientTypeId;

    // Add FK relationship annotation
    @Column(name = "delivery_code_type")
    private int deliveryCodeType;

}// w2ClientTNG Class
