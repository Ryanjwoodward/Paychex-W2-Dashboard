package com.gcucapstone.paychexdashboard.entity;

import lombok.*;

import javax.persistence.*;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created) 10-11-2022
 * File:           | W2Vendor.java
 * Version:        | 1.0
 * Description:    | This class represents the w2_vendor_information table/entity in the
 *                 | PaychexDashboard DB. It will be used to create Vendor Entities and
 *                 | establish relationship between tables with fields/ attributes
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
        name = "w2_vendor_information",
        schema = "PaychexDashboard"
)
public class W2Vendor {

    //----------------------------------------------------
    // Instance Variables
    //----------------------------------------------------

    @EmbeddedId
    private BranchClient vendorId;

    @Column(name = "vendor_employee_count")
    private int employeeCount;

    @Column(name = "vendor_w2_count")
    private int w2Count;

    //Add Foreign Key reltionship annotation
    @Column(name = "w2_vendor_type")
    private int type;

}// W2Vendor Class