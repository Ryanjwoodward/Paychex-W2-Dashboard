package com.gcucapstone.paychexdashboard.entity;

import lombok.*;

import javax.persistence.*;

/**-------------------------------------------------------------------
  Authors:      | Ryan Woodward & Chris Robles
  Class:        | STG451 - Capstone 1
  Institution:  | Grand Canyon University &  Paychex
  Instructor:   | Dr. Isac Artzi
  Date:         | (created) 10-11-2022
  File:         | lookupType.java
  Version:      | 1.0
  Description:  | This class represents the loolup_types table/entity in the PaychexDashboard DB
  				| It will be used to create loopkupType records and determine relationship between tables with fields/attributes
---------------------------------------------------------------------
Notes:

----------------------------------------------------------------------*/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(
		name = "lookup_types",
		schema = "PaychexDashboard"
)
public class LookupType {

	//----------------------------------------------------
	// Instance Variables
	//----------------------------------------------------
	@Id
	@Column(name = "lookup_type_id")
	private int lookupTypeId;


	@Column(name = "lookup_type")
	private String lookupType;

}// lookupType Class

