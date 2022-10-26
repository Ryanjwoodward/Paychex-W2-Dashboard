package com.gcucapstone.paychexdashboard.entity;

import lombok.*;

import javax.persistence.*;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Class:          | STG451 - Capstone 1
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created) 10-11-2022
 * File:           | lookupTable.java
 * Version:        | 1.0
 * Description:    | This class represents the lookup_Table table/entity in the PaychexDashboard DB
 *                 | It will be used to create lookup_Table records and to establish relationships
 *                 | between tables with fields/attributes
 * ---------------------------------------------------------------------------
 Notes:

 ----------------------------------------------------------------------*/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(
        name = "lookup_table",
        schema = "PaychexDashboard"
)
public class LookupTable {

    //----------------------------------------------------
    // Instance Variables
    //----------------------------------------------------
    @Id
    @Column(name = "lookup_id")
    private Long lookupId;

    @Column(name = "lookup_abbreviation")
    private String abbreviation;

    @Column(name = "lookup_description")
    private String description;

    @Column(name = "lookup_full_name")
    private String fullName;

    @OneToOne
    @JoinColumn(name = "lookup_type_id", referencedColumnName = "lookup_type_Id", foreignKey=@ForeignKey(name = "Fk_lookup_type_id "))
    private LookupType lookupTypeId;

}// lookupTable Class
