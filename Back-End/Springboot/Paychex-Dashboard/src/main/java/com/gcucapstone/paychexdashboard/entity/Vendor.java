package com.gcucapstone.paychexdashboard.entity;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvBindByPositions;
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

 ----------------------------------------------------------------------*/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(
        name = "vendor",
        schema = "PaychexDashboard"
)
public class Vendor {

    //----------------------------------------------------
    // Instance Variables
    //----------------------------------------------------

    @CsvBindByName(column = "Vendor ID")
    @EmbeddedId
    private BranchClient vendorId;

    @CsvBindByName(column = "Employee Count")
    @Column(name = "vendor_employee_count")
    private int employeeCount;

    @CsvBindByName(column = "W2 Count")
    @Column(name = "vendor_w2_count")
    private int w2Count;

    @CsvBindByName(column = "Vendor Table")
    @OneToOne
    @JoinColumn(name = "vendor_lookup_id", referencedColumnName = "lookup_id", foreignKey=@ForeignKey(name = "Fk_vendor_lookup_Id"))
    private LookupTable lookupId;

}// W2Vendor Class
