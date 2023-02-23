package com.gcucapstone.paychexdashboard.repository;

import com.gcucapstone.paychexdashboard.entity.BranchClient;
import com.gcucapstone.paychexdashboard.entity.LookupTable;
import com.gcucapstone.paychexdashboard.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-21-2022
 * File:           | VendorRepository.java
 * Version:        | 1.0
 * Description:    |This interface file is where JPARepository Methods, JPQL and
 *                 | native SQL Query methods will be defined for Vendor entities
 * ---------------------------------------------------------------------------
 *  Notes:
 *
 *  //Find by LookupTable lookup Id, reference Address/Order
 *----------------------------------------------------------------------------*/
public interface VendorRepository extends JpaRepository<Vendor, BranchClient> {

   //----------------------------------------------------
   // Query Test Methods
   //----------------------------------------------------

   //--------------------------------
   // Find by Individual Attributes
   //--------------------------------

   /**
    * This method is a custom written JPQL Query method that returns a located vendor
    * records that correspond to the passed branch parameter
    * @param Branch  - the branch id of the vendor record
    * @return        - the returned vendor record(s)
    */
   @Query("SELECT v FROM Vendor v WHERE v.vendorId.branch = ?1")
   List<Vendor> findByBranch(String Branch);

   /**
    * This method is a custom written JPQL Query method that returns a located vendor
    * record that corresponds to the passed client ID  parameter
    * @param clientId   - the client ID of the vendor record
    * @return           - the vendor record(s)
    */
   @Query("SELECT v FROM Vendor v WHERE v.vendorId.clientId = ?1")
   Vendor findByClientId(String clientId);


   /**
    * This method returns a list of Vendors that match the number  of employees
    * as a passed parameter.
    * @param employeeCount - the number of employees
    * @return              - the vendor records
    */
   List<Vendor> findByEmployeeCount(int employeeCount);

   /**
    * This method returns a list of vendors that have a employee count
    * greater than the passed parameter
    * @param employeeCount - the number of employees to compare
    * @return              - return the vendor records
    */
   List<Vendor> findByEmployeeCountGreaterThan(int employeeCount);

   /**
    * This method returns a list of vendors that have an employee count
    * that is less than the passeed parameter
    * @param employeeCount  - the number of employees to search for
    * @return               - the list of Vendors
    */
   List<Vendor> findByEmployeeCountLessThan(int employeeCount);

   /**
    * This method returns a list of vendor records whose employee count
    * is between the passed paramaters
    * @param count1  - first boundary: number  of employees
    * @param count2  - second boundary: number of employees
    * @return        - the list of vendor records
    */
  List<Vendor> findByEmployeeCountBetween(int count1, int count2);

   /**
    * This method returns a list of vendor records whose W2 count
    * matches the passed parameter
    * @param w2Count - the number of the W2's to search for
    * @return        - the list of vendor records
    */
  List<Vendor> findByW2Count(int w2Count);

   /**
    * This method returns a list of vendor records that have a greater value
    * than the passed parameter, number of W2's
    * @param w2Count - the number of W2's
    * @return        - list of vendor records
    */
  List<Vendor> findByW2CountGreaterThan(int w2Count);

   /**
    * This method returns a list of vendor records that have a lesser value
    * than the passed parameter, number of W2's
    * @param w2Count - the number of W2's
    * @return        - list of vendor records
    */
  List<Vendor> findByW2CountLessThan(int w2Count);

   /**
    * This method returns a list of vendor records that have a value between the
    * passed parameters of W2 count
    * @param w2Count1   - the first boundary: number of W2's
    * @param w2Count2   - the second boundary: number of W2's
    * @return           - the List of Vendor Records
    */
  List<Vendor> findByW2CountBetween(int w2Count1, int w2Count2);

    /**
     * This method returns  al ist of Vendor records that have a LookupId
     * that matches the passed parameter
     * @param lookupId  - the lookupId to search for
     * @return          - Vendor record
     */
  Vendor findByLookupId(LookupTable lookupId);


   //--------------------------------
   // Find by Multiple Attributes
   //--------------------------------

   /**
    * This method is a custom written JPQL Query method that returns a located vendor
    * record that corresponds to both of the passed Branch and client ID parameter
    * @param Branch     - the Branch name to search for
    * @param clientId   - the clientID to search for
    * @return           - vendor record(s)
    */
   @Query("SELECT v FROM Vendor v WHERE v.vendorId.branch = ?1 AND v.vendorId.clientId = ?2")
   List<Vendor> findByBranchAndClientId(String Branch, String clientId);

   /**
    * This method is a custom written JPQL Query method that returns o located vendor
    * record that corresponds to at least one of the passed Branch of Client ID parameters
    * @param branch     - the Branch name to search for
    * @param clientId   - the client ID to search for
    * @return           - vendor record(s)
    */
   @Query("SELECT v FROM Vendor v WHERE v.vendorId.branch = ?1 OR v.vendorId.clientId = ?2")
   List<Vendor> findByBranchOrClientId(String branch, String clientId);


    /**
     * This method is a custom written JPQL Query method that returns a list of
     * Vendor records that have a state attribute (of their LookupTable FK attribute)
     * that matches the passed argument
     * @param state - the state attribute to search for
     * @return      - a List of Vendor records
     */
   @Query("SELECT v FROM Vendor v WHERE v.lookupId.state = ?1")
   List<Vendor> findByLookupTableState(String state);

   @Query("SELECT v FROM Vendor v WHERE v.lookupId.lookupId = ?1")
   Vendor findByLookupTableCarrierId(Long id);


}// VendorRepository Interface
