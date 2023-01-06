/************************************************************
********** Insert records into lookupTypes ***********/
/*NOTE: 
	vendors numbers start with 1
    carriers numbers start with 3
    client numbers start with 8
*/

/*----- VENDOR RECORDS -----*/
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('1234', 'vendor');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('1233', 'vendor');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('1214', 'vendor');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('1314', 'vendor');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('1541', 'vendor');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('1987', 'vendor');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('1761', 'vendor');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('1432', 'vendor');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('1643', 'vendor');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('1422', 'vendor');

/*----- CARRIER RECORDS -----*/
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('3467', 'carrier');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('3321', 'carrier');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('3331', 'carrier');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('3987', 'carrier');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('3876', 'carrier');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('3772', 'carrier');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('3087', 'carrier');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('3213', 'carrier');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('3214', 'carrier');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('3542', 'carrier');

/*----- CLIENT RECORDS -----*/
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('8910', 'client');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('8810', 'client');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('8765', 'client');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('8213', 'client');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('8123', 'client');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('8456', 'client');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('8345', 'client');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('8125', 'client');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('8998', 'client');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('8076', 'client');

/************************************************************
********** Insert records into lookupTable ***********/

/*----- LOOKUPTABLE: VENDOR RECORDS -----*/
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`, `state`, `lookup_type_id`) 
    VALUES ('1234', 'VEN', 'vendor description', 'vendor name', 'AZ', '1234');
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`, `state`, `lookup_type_id`) 
    VALUES ('1098', 'VEN', 'frys vendor description', 'Frys', 'AZ', '1233');  
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`, `state`,`lookup_type_id`) 
    VALUES ('1011', 'VEN', 'walmart vendor description', 'Walmart', 'TX', '1214');  
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`, `state`,`lookup_type_id`) 
    VALUES ('1043', 'VEN', 'Costco vendor description', 'Costco','TX', '1314');  
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`,`state`, `lookup_type_id`) 
    VALUES ('1076', 'VEN', 'Intel vendor description', 'Intel','NY', '1541');
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`,`state`, `lookup_type_id`) 
    VALUES ('1054', 'VEN', 'Arm vendor description', 'ARM', 'NY','1987');
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`,`state`, `lookup_type_id`) 
    VALUES ('1023', 'VEN', 'Microchip vendor description', 'Microchip','WI', '1761');
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`, `state`,`lookup_type_id`) 
    VALUES ('1021', 'VEN', 'Amazon vendor description', 'Amazon','WI', '1432');
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`,`state`, `lookup_type_id`) 
    VALUES ('1011', 'VEN', 'Apple vendor description', 'Apple','NC', '1643');
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`,`state`, `lookup_type_id`) 
    VALUES ('1033', 'VEN', 'Google vendor description', 'Google','FL', '1422');


/*----- LOOKUPTABLE: CARRIER RECORDS -----*/
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`,`state`, `lookup_type_id`) 
    VALUES ('3054', 'CAR', 'DHL carrier description', 'DHL','CA', '3467');
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`, `state`,`lookup_type_id`) 
    VALUES ('3066', 'CAR', 'Fedex carrier description', 'Fedex','NM', '3321');
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`,`state`, `lookup_type_id`) 
    VALUES ('3011', 'CAR', 'UPS carier description', 'UPS','NM', '3331');
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`, `state`,`lookup_type_id`) 
    VALUES ('3021', 'CAR', 'Amazon Carrier Description', 'Amazon', 'NV', '3987');
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`, `state`,`lookup_type_id`) 
    VALUES ('3098', 'CAR', 'XPL carrier description', 'XPL','NV', '3876');
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, 'WA',`lookup_abbreviation`, `lookup_description`, `lookup_full_name`,`state`, `lookup_type_id`) 
    VALUES ('3076', 'CAR', 'JB Hunt Carrier Description', 'JB Hunt', 'WA','3772');
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`,`state`, `lookup_type_id`) 
    VALUES ('3077', 'CAR', 'Knight-Swift Carrier Description', 'Knight-Swift','OK', '3087');
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`, `state`,`lookup_type_id`) 
    VALUES ('3061', 'CAR', 'Old Dominion Carrier Description', 'Old Dominion','TN', '3213');
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`,`state`, `lookup_type_id`) 
    VALUES ('3099', 'CAR', 'Penske Carrier Description', 'Penske','TN', '3214');
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`, `state`,`lookup_type_id`) 
    VALUES ('3012', 'CAR', 'YRC Carrier Description', 'YRC Worldwide','AZ', '3542');
    

/*----- LOOKUPTABLE: CLIENT RECORDS -----*/
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`,`state`, `lookup_type_id`) 
    VALUES ('8910', 'CLT', 'client description', 'client name', 'AZ', '8910');
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`,`state`, `lookup_type_id`) 
    VALUES ('8012', 'CLT', 'Costco Client Description', 'Description', 'AZ', '8810');
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`, `state`,`lookup_type_id`) 
    VALUES ('8023', 'CLT', 'Amazon Client Description', 'Amazon', 'AZ', '8765');
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`,`state`, `lookup_type_id`) 
    VALUES ('8045', 'CLT', 'Apple Client Description', 'Apple', 'AZ', '8213');
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`, `state`,`lookup_type_id`) 
    VALUES ('8067', 'CLT', 'Carhartt Client Description', 'Carhartt', 'AZ', '8123');
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`, `state`,`lookup_type_id`) 
    VALUES ('8089', 'CLT', 'Bass Pro Client Description', 'Bass Pro Shops', 'NY', '8456');
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`, `state`,`lookup_type_id`) 
    VALUES ('8091', 'CLT', 'Star Fleet Client Descripition', 'Star Fleet','NY', '8345');
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`, `state`,`lookup_type_id`) 
    VALUES ('8097', 'CLT', 'The Dominion Client Description', 'The Dominion','NY', '8125');
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`, `state`,`lookup_type_id`) 
    VALUES ('8013', 'CLT', 'Romulan Empire Client Description', 'Romulan Empire','NY', '8998');
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`,`state`, `lookup_type_id`) 
    VALUES ('8078', 'CLT', 'Klingon Empire CLient Description', 'Klingon Empire','NY', '8076');
    

/************************************************************
********** Insert records into Vendor Table ***********/
INSERT INTO `PaychexDashboard`.`vendor` (`branch`, `client_id`, `vendor_employee_count`, `vendor_w2_count`, `vendor_lookup_id`) 
    VALUES ('south', 'frys-1098', '230234', '230234', '1098');
INSERT INTO `PaychexDashboard`.`vendor` (`branch`, `client_id`, `vendor_employee_count`, `vendor_w2_count`, `vendor_lookup_id`) 
    VALUES ('south', 'walm-1011', '125521', '125521', '1011');
INSERT INTO `PaychexDashboard`.`vendor` (`branch`, `client_id`, `vendor_employee_count`, `vendor_w2_count`, `vendor_lookup_id`) 
    VALUES ('southwest', 'cosc-1043', '2501233', '2501233', '1043');    
INSERT INTO `PaychexDashboard`.`vendor` (`branch`, `client_id`, `vendor_employee_count`, `vendor_w2_count`, `vendor_lookup_id`) 
    VALUES ('southwest', 'intl-1076', '13451', '13451', '1076');
INSERT INTO `PaychexDashboard`.`vendor` (`branch`, `client_id`, `vendor_employee_count`, `vendor_w2_count`, `vendor_lookup_id`) 
    VALUES ('great lakes', 'armd-1054', '702', '702', '1054');
INSERT INTO `PaychexDashboard`.`vendor` (`branch`, `client_id`, `vendor_employee_count`, `vendor_w2_count`, `vendor_lookup_id`) 
    VALUES ('great lakes', 'micr-1023', '12432', '12432', '1023');
INSERT INTO `PaychexDashboard`.`vendor` (`branch`, `client_id`, `vendor_employee_count`, `vendor_w2_count`, `vendor_lookup_id`) 
    VALUES ('cascadia', 'appl-1011', '320412', '320412', '1011');
INSERT INTO `PaychexDashboard`.`vendor` (`branch`, `client_id`, `vendor_employee_count`, `vendor_w2_count`, `vendor_lookup_id`) 
    VALUES ('cascadia', 'amaz-1021', '520345', '520345', '1021');
INSERT INTO `PaychexDashboard`.`vendor` (`branch`, `client_id`, `vendor_employee_count`, `vendor_w2_count`, `vendor_lookup_id`) 
    VALUES ('gulf coast', 'goog-1033', '230456', '230456', '1033');

/************************************************************
********** Insert records into Carrier Table ***********/
INSERT INTO `PaychexDashboard`.`carrier` (`branch`, `client_id`, `destination_address`, `tracking_id`, `carrier_lookup_id`, `delviery_status_type_id`) 
    VALUES ('cascadia', 'dhld-3054', '3054 W. Santos Ave.', 'tid-dhld-3054', '3054', '3054');
INSERT INTO `PaychexDashboard`.`carrier` (`branch`, `client_id`, `destination_address`, `tracking_id`, `carrier_lookup_id`, `delviery_status_type_id`) 
    VALUES ('southwest', 'fedx-3066', '3066 S. Enchantment Blvd.', 'tid-fedx-3066', '3066', '3066');
INSERT INTO `PaychexDashboard`.`carrier` (`branch`, `client_id`, `destination_address`, `tracking_id`, `carrier_lookup_id`, `delviery_status_type_id`) 
    VALUES ('southwest', 'upsd-3011', '3011 W. Albuquerque Rd.', 'tid-upsd-3011', '3011', '3011');
INSERT INTO `PaychexDashboard`.`carrier` (`branch`, `client_id`, `destination_address`, `tracking_id`, `carrier_lookup_id`, `delviery_status_type_id`) 
    VALUES ('deseret', 'amaz-3021', '3021 N. Henderson blvd.', 'tid-amaz-3021', '3021', '3021');
INSERT INTO `PaychexDashboard`.`carrier` (`branch`, `client_id`, `destination_address`, `tracking_id`, `carrier_lookup_id`, `delviery_status_type_id`) 
    VALUES ('deseret', 'xpld-3098', '3098 E. Vegas Ave.', 'tid-xpld-3098', '3098', '3098');
INSERT INTO `PaychexDashboard`.`carrier` (`branch`, `client_id`, `destination_address`, `tracking_id`, `carrier_lookup_id`, `delviery_status_type_id`) 
    VALUES ('mountain west', 'jbhd-3076', '3076 E. Seattle Rd.', 'tid-xpld-3076', '3076', '3076');
INSERT INTO `PaychexDashboard`.`carrier` (`branch`, `client_id`, `destination_address`, `tracking_id`, `carrier_lookup_id`, `delviery_status_type_id`) 
    VALUES ('midwest', 'knsw-3077', '3077 S. Okie St.', 'tid-knsw-3077', '3077', '3077');
INSERT INTO `PaychexDashboard`.`carrier` (`branch`, `client_id`, `destination_address`, `tracking_id`, `carrier_lookup_id`, `delviery_status_type_id`) 
    VALUES ('south atlantic', 'oldd-3061', '3061 N. Chattanooga Ave.', 'tid-oldd-3061', '3061', '3061');
INSERT INTO `PaychexDashboard`.`carrier` (`branch`, `client_id`, `destination_address`, `tracking_id`, `carrier_lookup_id`, `delviery_status_type_id`) 
    VALUES ('south atlantic', 'pens-3099', '3099 S. Nashville Way.', 'tid-pens-3099', '3099', '3099');
INSERT INTO `PaychexDashboard`.`carrier` (`branch`, `client_id`, `destination_address`, `tracking_id`, `carrier_lookup_id`, `delviery_status_type_id`) 
    VALUES ('southwest', 'yrcd-3012', '3012 E. Camelback Rd.', 'tid-yrcd-3012', '3012', '3012');

/************************************************************
********** Insert records into Client Table ***********/


INSERT INTO `PaychexDashboard`.`client` (`w2_transmission_id`, `branch`, `created_date`, `employee_count`, 
`transmission_file`,`w2_count`, `w2_delivery_address`, `client_type_id`, `delivery_code_type`) 
    VALUES ('costco-trm-8012', 'southwest', '2021-11-05', '450', 'costco-8910-trm-file.csv', 
    '450', '8012 S. 1st St.', '8012', '8012');
INSERT INTO `PaychexDashboard`.`client` (`w2_transmission_id`, `branch`, `created_date`, `employee_count`, 
`transmission_file`,`w2_count`, `w2_delivery_address`, `client_type_id`, `delivery_code_type`) 
    VALUES ('amazon-trm-8023', 'southwest', '2022-12-01', '1200', 'amazon-8023-trm-file.csv', 
    '1200', '8023 W. Guadalupe Rd.', '8023', '8023');
INSERT INTO `PaychexDashboard`.`client` (`w2_transmission_id`, `branch`, `created_date`, `employee_count`, 
`transmission_file`,`w2_count`, `w2_delivery_address`, `client_type_id`, `delivery_code_type`) 
    VALUES ('apple-trm-8045', 'southwest', '2022-10-06', '320', 'apple-8045-trm-file.csv', 
    '320', '8045 E. Mill Ave.', '8045', '8045');
INSERT INTO `PaychexDashboard`.`client` (`w2_transmission_id`, `branch`, `created_date`, `employee_count`, 
`transmission_file`,`w2_count`, `w2_delivery_address`, `client_type_id`, `delivery_code_type`) 
    VALUES ('carhartt-trm-8067', 'southwest', '2022-11-11', '120', 'carhartt-8067-trm-file.csv', 
    '120', '8067 S. Rural Rd.', '8067', '8067');
INSERT INTO `PaychexDashboard`.`client` (`w2_transmission_id`, `branch`, `created_date`, `employee_count`, 
`transmission_file`,`w2_count`, `w2_delivery_address`, `client_type_id`, `delivery_code_type`) 
    VALUES ('basspro-8089', 'great lakes', '2022-11-15', '300', 'basspro-8089-trm-file.csv', 
    '300', '8089 S. Central Ave.', '8089', '8089');
INSERT INTO `PaychexDashboard`.`client` (`w2_transmission_id`, `branch`, `created_date`, `employee_count`, 
`transmission_file`,`w2_count`, `w2_delivery_address`, `client_type_id`, `delivery_code_type`) 
    VALUES ('starfleet-8091', 'great lakes', '2233-12-10', '200000', 'starfleet-8091-trm-file.csv', 
    '2000000', '8091 W. Picard Blvd.', '8091', '8091');
INSERT INTO `PaychexDashboard`.`client` (`w2_transmission_id`, `branch`, `created_date`, `employee_count`, 
`transmission_file`,`w2_count`, `w2_delivery_address`, `client_type_id`, `delivery_code_type`) 
    VALUES ('dominion-8097', 'great lakes', '2234-11-05', '12000000', 'dominion-8097-trm-file.csv', 
    '120000000', '8097 W. Founders Way', '8097', '8097');
INSERT INTO `PaychexDashboard`.`client` (`w2_transmission_id`, `branch`, `created_date`, `employee_count`, 
`transmission_file`,`w2_count`, `w2_delivery_address`, `client_type_id`, `delivery_code_type`) 
    VALUES ('romulan-8013', 'great lakes', '2234-05-05', '300120', 'romulan-8013-trm-file.csv', 
    '300120', '8013 N. Warbird Rd.', '8013', '8013');
INSERT INTO `PaychexDashboard`.`client` (`w2_transmission_id`, `branch`, `created_date`, `employee_count`, 
`transmission_file`,`w2_count`, `w2_delivery_address`, `client_type_id`, `delivery_code_type`) 
    VALUES ('klingon-8078', 'great lakes', '2345-10-11', '254344', 'klingon-8078-trm-file.csv', 
    '254344', '8078 N. Pahtak Ave.', '8078', '8078');