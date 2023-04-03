package com.gcucapstone.paychexdashboard.entity;

import com.opencsv.bean.CsvBindByName;
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

----------------------------------------------------------------------*/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(
		name = "carrier",
		schema = "PaychexDashboard"
)
public class Carrier {

	//----------------------------------------------------
	// Instance Variables
	//----------------------------------------------------

	@CsvBindByName(column = "Carrier ID")
	@EmbeddedId
	private BranchClient carrierId;

	@CsvBindByName(column = "Destination Address")
	@Column(name = "destination_address")
	private String destinationAddress;

	@CsvBindByName(column = "Tracking ID")
	@Column(name = "tracking_id")
	private String trackingId;

	@OneToOne
	@JoinColumn(name = "carrier_lookup_id", referencedColumnName = "lookup_id", foreignKey=@ForeignKey(name = "Fk_carrier_lookup_id"))
	private LookupTable carrierLookupId;

	@CsvBindByName(column = "Delivery Status")
	@OneToOne
	@JoinColumn(name = "delviery_status_type_id", referencedColumnName = "lookup_id", foreignKey=@ForeignKey(name = "Fk_carrier_delivery_lookup_id"))
	private LookupTable deliveryStatusTypeId;

}// w2Carrier Class
