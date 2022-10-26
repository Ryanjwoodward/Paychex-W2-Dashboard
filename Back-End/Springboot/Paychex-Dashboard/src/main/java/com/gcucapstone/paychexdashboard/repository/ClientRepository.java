package com.gcucapstone.paychexdashboard.repository;

import com.gcucapstone.paychexdashboard.entity.Client;
import com.gcucapstone.paychexdashboard.entity.LookupTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-21-2022
 * File:           | ClientRepository.java
 * Version:        | 1.0
 * Description:    |This interface file is where JPARepository Methods, JPQL and
 *                 | native SQL Query methods will be defined for Client entities
 * ---------------------------------------------------------------------------
 * Notes:
 *  - create findBy-CreatedDates?
 *----------------------------------------------------------------------------*/
public interface ClientRepository extends JpaRepository<Client, String> {

    //----------------------------------------------------
    // Query Method Definitions
    //----------------------------------------------------

    //---------------------------------------
    // *** Find By Individual Attributes ***
    //---------------------------------------

    /**
     * This is method returns a Client record that has a w2TransmissionId
     * attribute that matches the passed parameter
     * @param w2TransmissionId  - the w2TransmissionId to search for
     * @return                  - the Client record
     */
    @Query("SELECT c FROM Client c WHERE c.w2TransmissionId = ?1")
    Client findByW2TransmissionId(String w2TransmissionId);

    /**
     * This method returns a Client record that has a branch attribute that
     * matches the passed parameter.
     * @param branch    - the branch to search for
     * @return          - the client record
     */
    Client findByBranch(String branch);

    /**
     * This method returns a list of Client records that have an attribute
     * employeeCount that matches the passed parameter.
     * @param employeeCount - the quantity of employees to search for
     * @return              - the list of Client records
     */
    List<Client> findByEmployeeCount(int employeeCount);

    /**
     * This method returns a client record that has a transmissionFile attribute
     * that matches the passed parameter
     * @param transmissionFile  - the transmission file to search for
     * @return                  - the client record
     */
    Client findByTransmissionFile(String transmissionFile);

    /**
     * This method returns a list of Client records that have a w2Count atttribute
     * that matches the passed parameter
     * @param w2Count   - the number of w2's to search for
     * @return          - the list of Client record(s)
     */
    List<Client> findByW2Count(int w2Count);

    /**
     * This method returns a list of Client records that have a W2DeliveryAddress
     * attribute that match the passed parameter
     * @param w2DeliveryAddress - the delivery address to search for
     * @return                  - the list of Client record(s)
     */
    List<Client> findByW2DeliveryAddress(String w2DeliveryAddress);

    /**
     * This method returns a Client record that has an attribute of clientTypeId
     * that matches the passed parameter.
     * @param clientTypeId  - the LookupTable to search for
     * @return              - the Client record
     */
    Client findByClientTypeId(LookupTable clientTypeId);

    Client findByDeliveryCodeTypeId(LookupTable deliveryCodeTypeId);

    //---------------------------------------
    // *** Find by Multiple Attributes
    //---------------------------------------

} //ClientRepository Interface
