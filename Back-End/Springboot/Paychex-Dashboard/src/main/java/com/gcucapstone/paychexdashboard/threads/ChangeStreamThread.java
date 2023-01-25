package com.gcucapstone.paychexdashboard.threads;

import com.gcucapstone.paychexdashboard.changeStreams.*;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)11-25-2022
 * File:           | ChangeStreamThread
 * Version:        | 1.0
 * Description:    | This Class will be used by ChangeStream Classes to run
 *                 | their watch operation on collections
 * ---------------------------------------------------------------------------
 */
public class ChangeStreamThread {

    public static void main(String[] args){

        //call constructors of each class t
        LookupTypeChangeStreams lookupTypeChangeStreams = new LookupTypeChangeStreams();
        VendorChangeStreams vendorChangeStreams = new VendorChangeStreams();
        ClientChangeStreams clientChangeStreams = new ClientChangeStreams();
        LookupTableChangeStreams lookupTableChangeStreams = new LookupTableChangeStreams();
        CarrierChangeStreams carrierChangeStreams = new CarrierChangeStreams();

        // call .start() on each
        lookupTypeChangeStreams.start();  //-- COMPLETED
        lookupTableChangeStreams.start(); //-- COMPLETED
        vendorChangeStreams.start();      //-- COMPLETED
        clientChangeStreams.start();
        carrierChangeStreams.start();     //-- COMPLETED
    }

}//ChangeStreamThread Class
