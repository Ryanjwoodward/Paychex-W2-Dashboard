package com.gcucapstone.paychexdashboard.controller;

import com.gcucapstone.paychexdashboard.entity.Client;
import com.gcucapstone.paychexdashboard.entity.LookupTable;
import com.gcucapstone.paychexdashboard.repository.ClientRepository;
import com.gcucapstone.paychexdashboard.repository.LookupTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-28-2022
 * File:           | ClientController.java
 * Version:        | 1.0
 * Description:    | This file will be used to create REST API's for Client
 *                 | entities such as basic CRUD methods
 * ---------------------------------------------------------------------------
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/dashboard/client")
public class ClientController {

    //----------------------------------------------------
    // Class Variables
    //----------------------------------------------------
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private LookupTableRepository lookupTableRepository;
    int[] attributeCounter = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    //----------------------------------------------------
    // Methods
    //----------------------------------------------------

    /**
     * This REST method maps a GET request to a ClientRepository instance
     * and calls it's extended JPARepository method findAll() and returns
     * a list of all Client Records found in the schema
     * @return  - a list of Client Records
     */
    @GetMapping("/clients/{sel}")
    public List<Client> getAllClients(@PathVariable(value = "sel")int selection){

        String[] attributes ={
                "w2TransmissionId", "branch", "createdDate", "employeeCount", "transmissionFile", "w2Count",
                "w2DeliveryAddress", "clientTypeId.lookupId", "deliveryCodeTypeId.State"
        };

        switch(selection){
            case 1: //vendorId.clientId
                if(attributeCounter[0] == 0) {
                    System.out.println("ATTR_COUNT: " + attributeCounter[0]);
                    attributeCounter[0] = 1;
                    System.out.println("ATTR_COUNT: " + attributeCounter[0]);
                    return clientRepository.findAll(Sort.by(attributes[0]).descending());
                }else if(attributeCounter[0] == 1){
                    System.out.println("ATTRCOUNT: " + attributeCounter[0]);
                    attributeCounter[0] = 0;
                    System.out.println("ATTRCOUNT: " + attributeCounter[0]);
                    return clientRepository.findAll(Sort.by(attributes[0]).ascending());
                }
            case 2://vendorId.branch
                if(attributeCounter[1] == 0) {
                    attributeCounter[1] = 1;
                    return clientRepository.findAll(Sort.by(attributes[1]).descending());
                }else{
                    attributeCounter[1] = 0;
                    return clientRepository.findAll(Sort.by(attributes[1]).ascending());
                }
            case 3://employeeCount
                if(attributeCounter[2] == 0) {
                    attributeCounter[2] = 1;
                    return clientRepository.findAll(Sort.by(attributes[2]).descending());
                }else{
                    attributeCounter[2] = 0;
                    return clientRepository.findAll(Sort.by(attributes[2]).ascending());
                }
            case 4://w2Count
                if(attributeCounter[3] == 0) {
                    attributeCounter[3] = 1;
                    return clientRepository.findAll(Sort.by(attributes[3]).descending());
                }else{
                    attributeCounter[3] = 0;
                    return clientRepository.findAll(Sort.by(attributes[3]).ascending());
                }
            case 5://lookupId.lookupId
                if(attributeCounter[4] == 0) {
                    attributeCounter[4] = 1;
                    return clientRepository.findAll(Sort.by(attributes[4]).descending());
                }else{
                    attributeCounter[4] = 0;
                    return clientRepository.findAll(Sort.by(attributes[4]).ascending());
                }
            case 6://lookupId.abbreviation
                if(attributeCounter[5] == 0) {
                    attributeCounter[5] = 1;
                    return clientRepository.findAll(Sort.by(attributes[5]).descending());
                }else{
                    attributeCounter[5] = 0;
                    return clientRepository.findAll(Sort.by(attributes[5]).ascending());
                }
            case 7://lookupId.description
                if(attributeCounter[6] == 0) {
                    attributeCounter[6] = 1;
                    return clientRepository.findAll(Sort.by(attributes[2]).descending());
                }else{
                    attributeCounter[6] = 0;
                    return clientRepository.findAll(Sort.by(attributes[2]).ascending());
                }
            case 8://lookupId.fullName
                if(attributeCounter[7] == 0) {
                    attributeCounter[7] = 1;
                    return clientRepository.findAll(Sort.by(attributes[7]).descending());
                }else{
                    attributeCounter[7] = 0;
                    return clientRepository.findAll(Sort.by(attributes[7]).ascending());
                }                case 9: //lookupId.state
            default: //all vendors
                return clientRepository.findAll();
        }    }


    /**
     * This REST method maps a GET request toa ClientRepository instance and calls
     * a JPA Named Query Method findByW2TransmissionId() and returns a Client
     * record that has an attribute of w2TransmissionId that matches the passed
     * parameter
     * @param transmissionId    - the transmissionId to search for
     * @return                  - the Client Record
     */
    @GetMapping("/transmissionid/{wtid}")
    public Client getClientByTransmissionId(@PathVariable(value = "wtid") String transmissionId){
        Client client = clientRepository.findByW2TransmissionId(transmissionId);
        return client;
    }

    /**
     * This REST method maps a GET request toa ClientRepository instance and calls
     * a JPA Named Query Method findByBranch() and returns a Client
     * record that has an attribute of branch that matches the passed parameter
     * @param branch   - the branch to search for
     * @return         - the Client Record
     */
    @GetMapping("/branch/{branch}")
    public List<Client> getClientByBranch(@PathVariable(value = "branch") String branch){
        List<Client> client = clientRepository.findByBranch(branch);
        return client;
    }

    /**
     * This REST method maps a GET a request to a ClientRepository instance and calls
     * a JPA Named Query method findByEmployeeCount() and returns a clist of
     * Client records that have an attribute of EmployeeCOunt that match the passed parameter
     * @param employeeCount - the employee count to search for
     * @return              - the list of client records
     */
    @GetMapping("/empcount/{empcount}")
    public List<Client> getClientsByEmployeeCount(@PathVariable(value = "empcount") int employeeCount){
        List<Client> clients = clientRepository.findByEmployeeCount(employeeCount);
        return clients;
    }

    /**
     * This REST method maps a GET request to a ClientRepository instance and calls
     * a JPA Named Query method: findByTransmissionFile() and returns a Client recod
     * that has an attribute of TransmissionFile that matches the passed Parameter
     * @param transmissionFile  - the transmission file to search for
     * @return                  - the Client record
     */
    @GetMapping("/transmissionfile/{transfile}")
    public Client getClientByTransmissionFile(@PathVariable(value = "transfile") String transmissionFile){
        Client client = clientRepository.findByTransmissionFile(transmissionFile);
        return client;
    }

    /**
     * This REST method maps a GET request to a ClientRepository instance and calls
     * a JPA Named Query method: findByW2Count() and returns a list of Client records
     * that has an attribute of TransmissionFile that matches the passed Parameter
     * @param w2Count  - the w2 count to search for
     * @return         - the Client records
     */
    @GetMapping("/w2count/{w2count}")
    public List<Client> getClientsByW2Count(@PathVariable(value = "w2count") int w2Count){
        List<Client> clients = clientRepository.findByW2Count(w2Count);
        return clients;
    }

    /**
     * This REST method maps a GET request to a ClientRepository instance and calls
     * a JPA Named Query method: findByW2DeliveryAddress() and returns a list of Client records
     * that has an attribute of w2DeliveryAddress that matches the passed Parameter
     * @param w2DeliveryAddress  - the w2DeliveryAddress to search for
     * @return                   - the Client records
     */
    @GetMapping("w2address/{w2deladdress}")
    public List<Client> getClientsByW2DeliveryAddress(@PathVariable(value = "w2deladdress")String w2DeliveryAddress){
        List<Client> clients = clientRepository.findByW2DeliveryAddress(w2DeliveryAddress);
        return clients;
    }

    /**
     * This REST method maps a GET request to a ClientRepository instance and calls
     * a JPA Named Query method: findByClientTypeId() and returns a Client record
     * that has an attribute of lookupid that matches the passed parameter
     * @param id    - the lookup id to search for
     * @return      - the Client record
     */
    @GetMapping("/clienttypeid/{tableid}")
    public Client getClientByClientTypeId(@PathVariable(value = "tableid")Long id){
        LookupTable table = lookupTableRepository.findByLookupId(id);
        Client client  = clientRepository.findByClientTypeId(table);
        return client;
    }

    /**
     * This REST method maps a GET request to a ClientRepository instance and calls
     * a JPA Named Query method: findByDeliveryCodeIf() and returns a Client record
     * that has an attribute of lookupid that matches the passed parameter
     * @param id    - the lookup id to search for
     * @return      - the Client record
     */
    @GetMapping("/deliverycodeid/{tableid}")
    public Client getClientByDeliveryCodeId(@PathVariable(value = "tableid")Long id){
        LookupTable table = lookupTableRepository.findByLookupId(id);
        Client client = clientRepository.findByDeliveryCodeTypeId(table);
        return client;
    }

    @GetMapping("/lookuptable/state/{state}")
    public List<Client> getClientByState(@PathVariable(value = "state")String state){

        List<Client> clients = clientRepository.findByLookupTableState(state);
        return clients;
    }

    @GetMapping("/lookuptable/states/{states}")
    @ResponseBody
    public List<Client> getClientByStates(@PathVariable(value = "states")List<String> states){

        List<Client> clients = new ArrayList<Client>();

        for(int idx = 0; idx < states.size(); idx++){
            clients.addAll(clientRepository.findByLookupTableState(states.get(idx)));
        }

        return clients;
    }

    @GetMapping("clientsort/{filtercriteria}/clients/{filtervalues}")
    @ResponseBody
    public List<Client> getFiltered(@PathVariable(value = "filtercriteria")List<Integer> criteriaAttributes,
                                         @PathVariable(value = "filtervalues")List<String> criteriaValues){


        List<Client> clients = new ArrayList<Client>();

        for(int idx = 0; idx < criteriaAttributes.size(); idx++){

            switch(criteriaAttributes.get(idx)){

                case 1 : //search for w2Transmission Id (single)

                    clients.add(clientRepository.findByW2TransmissionId(criteriaValues.get(idx)));
                    break;

                case 2 : // search for branch (mult)

                    clients.addAll(clientRepository.findByBranch(criteriaValues.get(idx)));
                    break;

                case 3 : // search for created Data (mult)

                    //no controller method
                    break;

                case 4 : // search for emp count (mult)

                    clients.addAll(clientRepository.findByEmployeeCount(Integer.parseInt(criteriaValues.get(idx))));
                    break;

                case 5: // search for transm file (mult)

                    clients.add(clientRepository.findByTransmissionFile(criteriaValues.get(idx)));
                    break;

                case 6 : //search for w2count (mult)

                    clients.addAll(clientRepository.findByW2Count(Integer.parseInt(criteriaValues.get(idx))));
                    break;

                case 7 : // search for w2 delivery address

                    clients.addAll(clientRepository.findByW2DeliveryAddress(criteriaValues.get(idx)));
                    break;

                case 8: // search for client type id (single)

                    clients.add(clientRepository.findByLookupTableClientTypeId(Long.valueOf(criteriaValues.get(idx))));
                    break;

                default:    // print an error

                    System.out.println("Feler...Something went Wrong!");
            }

        }

        return clients;
    }

}//ClientController Class
