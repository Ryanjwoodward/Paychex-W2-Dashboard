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
    - Need to add FK relationship annotation to the final column
 ----------------------------------------------------------------------*/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
    private int lookupId;

    @Column(name = "lookup_abbreviation")
    private String abbreviation;

    @Column(name = "lookup_description")
    private String description;

    @Column(name = "lookup_full_name")
    private String fullName;

    //Add Foreign Key Relationship Annotation
    @Column(name = "lookup_type_id")
    private int typeId;

}// lookupTable Class
