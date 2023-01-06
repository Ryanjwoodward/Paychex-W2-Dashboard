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
        //LookupTypeChangeStreams lookupTypeChangeStreams = new LookupTypeChangeStreams();
        LookupTableChangeStreams lookupTableChangeStreams = new LookupTableChangeStreams();
  /*      ClientChangeStreams clientChangeStreams = new ClientChangeStreams();
        VendorChangeStreams vendorChangeStreams = new VendorChangeStreams();
        CarrierChangeStreams carrierChangeStreams = new CarrierChangeStreams();*/

        // call .start() on each
        //lookupTypeChangeStreams.start();
        lookupTableChangeStreams.start();
      /*  clientChangeStreams.start();
        vendorChangeStreams.start();
        carrierChangeStreams.start();*/
    }

}//ChangeStreamThres Class
