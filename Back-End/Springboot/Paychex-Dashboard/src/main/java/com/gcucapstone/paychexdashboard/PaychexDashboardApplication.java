package com.gcucapstone.paychexdashboard;

import com.gcucapstone.paychexdashboard.changeStreams.LookupTableChangeStreams;
import com.gcucapstone.paychexdashboard.changeStreams.LookupTypeChangeStreams;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**-------------------------------------------------------------------
  Authors:      | Ryan Woodward & Chris Robles
  Class:        | STG451 - Capstone 1
  Institution:  | Grand Canyon University &  Paychex
  Instructor:   | Dr. Isac Artzi
  Date:         | (created) 10-11-2022
  File:         | PaychexDashboardApplication.java
  Version:      | 1.0
  Description:  | This is the generated application file from spring initializer
  				| This file is executed to run the backend application/client of the Paychex W2 dashboard
---------------------------------------------------------------------
Notes:
 Multiple contructor call will not work for the application, rather try to
 create a single changeStream that watches the Database rather than a single collection
----------------------------------------------------------------------*/
@SpringBootApplication
public class PaychexDashboardApplication {

	public static void main(String[] args) {

		SpringApplication.run(PaychexDashboardApplication.class, args);
		LookupTypeChangeStreams typeChangeStreams = new LookupTypeChangeStreams();
	}


}// PaychexDashboardApplication Class
