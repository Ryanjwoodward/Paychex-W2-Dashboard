package com.gcucapstone.paychexdashboard.entity;

import com.opencsv.bean.CsvBindByName;
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
        name = "client",
        schema = "PaychexDashboard"
)
public class Client {

    //----------------------------------------------------
    // Instance Variables
    //----------------------------------------------------
    @CsvBindByName(column = "W2 Transmission ID")
    @Id
    @Column(name = "w2_transmission_id")
    private String w2TransmissionId;

    @CsvBindByName(column = "Branch")
    @Column(name = "branch")
    private String branch;

    @CsvBindByName(column = "Created Date")
    @Column(name = "created_date")
    private String createdDate;

    @CsvBindByName(column = "Employee Count")
    @Column(name = "employee_count")
    private int employeeCount;

    @CsvBindByName(column = "Transmission File")
    @Column(name = "transmission_file")
    private String transmissionFile;

    @CsvBindByName(column = "W2 Count")
    @Column(name = "w2_count")
    private int w2Count;

    @CsvBindByName(column = "Delivery Address")
    @Column(name = "w2_delivery_address")
    private String w2DeliveryAddress;

    @CsvBindByName(column = "Client Type")
    @OneToOne
    @JoinColumn(name = "client_type_id", referencedColumnName = "lookup_id", foreignKey=@ForeignKey(name = "Fk_client_lookup_id"))
    private LookupTable clientTypeId;

    @OneToOne
    @JoinColumn(name = "delivery_code_type", referencedColumnName = "lookup_id", foreignKey=@ForeignKey(name = "Fk_client_delivery_lookup_id"))
    private LookupTable deliveryCodeTypeId;

}// w2ClientTNG Class
