package com.gcucapstone.paychexdashboard.repository;

import com.gcucapstone.paychexdashboard.entity.BranchClient;
import com.gcucapstone.paychexdashboard.entity.Carrier;
import com.gcucapstone.paychexdashboard.entity.LookupTable;
import com.gcucapstone.paychexdashboard.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created) 10-14-2022
 * File:           | MongoCarrierRepository.java
 * Version:        | 1.0
 * Description:    | This interface file is where JPARepository Methods, JPQL and
 *                 | native SQL Query methods will be defined for Carrier entities
 * ---------------------------------------------------------------------------
 * Notes:
 *
 *---------------------------------------------------------------------------*/
public interface CarrierRepository extends JpaRepository<Carrier, BranchClient> {

    //----------------------------------------------------
    // Query Method Definitions
    //----------------------------------------------------

    //---------------------------------------
    // *** Find By Individual Attributes ***
    //---------------------------------------

    /**
     * This method returns a list of Carrier records that have a branch id that
     * matches the passed parameter
     * @param Branch    - barnch Id to search for
     * @return          - Carrier records
     */
    @Query("SELECT c FROM Carrier c WHERE c.carrierId.branch = ?1")
    List<Carrier> findByBranch(String Branch);

    /**
     * This method returns a list of Carrier records that have a client id that
     * matches the passed paramater
     * @param clientId  - client Id to search for
     * @return          - the Carrier records
     */
    @Query("SELECT c FROM Carrier c WHERE c.carrierId.clientId = ?1")
    Carrier findByClientId(String clientId);
    //find By tracking_id

    /**
     * This method returns a list of Carrier records that have a destination address
     * that match the passed parameter.
     * @param destinationAddress    - the destination address to search for
     * @return                      - the Carrier records
     */
    List<Carrier> findByDestinationAddress(String destinationAddress);

    /**
     * This method returns a list of Carrier records that have a tracking id
     * that match the passed parameter
     * @param trackingId    - the tracking id to search for
     * @return              - Carrier records
     */
    Carrier findByTrackingId(String trackingId);

    /**
     * This method returns a Carrier record with a LookupTable attribute
     * that matches the passed parameter.
     * @param lookupId  - the lookUpTable to search for
     * @return          - the Carrier record
     */
    Carrier findByCarrierLookupId(LookupTable lookupId);

    /**
     * This method returns a List of Carrier records that have a state
     * attribute (of their LookupTable FK) that match the passed argument
     * @param state    - the state atribute to search for
     * @return         - the List of vendor Records
     */
    @Query("SELECT c FROM Carrier c WHERE c.carrierLookupId.state =?1")
   List<Carrier> findByLookupTableState(String state);

    /**
     * This method returns a Carrier record that corresponds to the passed
     * carrierLookupID argument
     * @param id
     * @return Carrier record
     */
    @Query("SELECT c FROM Carrier c WHERE c.carrierLookupId.lookupId = ?1")
    Carrier findByLookupTableCarrierLookupId(Long id);

}// MongoCarrierRepository Interface
