package com.gcucapstone.paychexdashboard.entity;

import lombok.*;

import javax.persistence.*;

/**-------------------------------------------------------------------
  Authors:      | Ryan Woodward
  Class:        | STG451 - Capstone 1
  Institution:  | Grand Canyon University & Paychex
  Instructor:   | Dr. Isac Artzi
  Date:         | (created) 10-11-2022
  File:         | w2Carrier.java
  Version:      | 1.0
  Description:  | This class represents the W2_carrier_information table/entity in the PaychexDashboard DB
  				| it will be used to create carrier entities and determine relationships with fields/attributes
---------------------------------------------------------------------
Notes:
 - Need to add FK relationship annotations to the latter two fields
----------------------------------------------------------------------*/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(
		name = "w2_carrier_information",
		schema = "PaychexDashboard"
)
public class Carrier {

	//----------------------------------------------------
	// Instance Variables
	//----------------------------------------------------

	@EmbeddedId
	private BranchClient carrierId;

	@Column(name = "destination_address")
	private String destinationAddress;

	@Column(name = "tracking_id")
	private String trackingId;

	// Add foreign key relationship annotation
	@Column(name ="carrier_type")
	private int carrierType;

	// Add foreign key relationship annotation
	@Column(name = "delivery_status_type")
	private int deliveryStatusType;

}// w2Carrier Class
