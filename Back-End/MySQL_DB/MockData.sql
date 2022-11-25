/* Insert a few records into lookupTypes */
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('1234', 'vendor');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('3467', 'carrier');
INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES ('8910', 'client');

/* insert a few records into lookup_table */
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`, `lookup_type_id`) VALUES ('1234', 'VEN', 'vendor description', 'vendor name', '1234');
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`, `lookup_type_id`) VALUES ('3467', 'CAR', 'carrier description', 'carrier name', '3467');
INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`, `lookup_type_id`) VALUES ('8910', 'CLT', 'client description', 'client name', '8910');

/*  insert a few records into Carrier table */
INSERT INTO `PaychexDashboard`.`carrier` (`branch`, `client_id`, `destination_address`, `tracking_id`, `carrier_lookup_id`, `delviery_status_type_id`) VALUES ('northwest', 'UPS', '8910 N Lebenraum Rd', '8910-TX', '1234', '1234');
INSERT INTO `PaychexDashboard`.`carrier` (`branch`, `client_id`, `destination_address`, `tracking_id`, `carrier_lookup_id`, `delviery_status_type_id`) VALUES ('southwest', 'FED EX', '1234 S. Unser Blvd.', '1178-PR', '3467', '3467');
INSERT INTO `PaychexDashboard`.`carrier` (`branch`, `client_id`, `destination_address`, `tracking_id`, `carrier_lookup_id`, `delviery_status_type_id`) VALUES ('northwest', 'Amazon', '899 W. Seliger Ave.', '7765-DG', '8910', '8910');

/* insert a few records into Vendor Table */
INSERT INTO `PaychexDashboard`.`vendor` (`branch`, `client_id`, `vendor_employee_count`, `vendor_w2_count`, `vendor_lookup_id`) VALUES ('northwest', '7765-DG', '117', '117', '8910');
INSERT INTO `PaychexDashboard`.`vendor` (`branch`, `client_id`, `vendor_employee_count`, `vendor_w2_count`, `vendor_lookup_id`) VALUES ('northwest', '1178-PR', '55', '55', '1234');
INSERT INTO `PaychexDashboard`.`vendor` (`branch`, `client_id`, `vendor_employee_count`, `vendor_w2_count`, `vendor_lookup_id`) VALUES ('southwest', '8910-TX', '205', '205', '3467');

/* insert a few records into the Client Table */
INSERT INTO `PaychexDashboard`.`client` (`w2_transmission_id`, `branch`, `created_date`, `employee_count`, `transmission_file`, `w2_count`, `w2_delivery_address`, `client_type_id`, `delivery_code_type`) VALUES ('amazon-w2-id', 'northwest', '2018-10-05', '1000', 'amazon-w2-files', '1000', '185 W Abschaum Ave', '8910', '8910');
INSERT INTO `PaychexDashboard`.`client` (`w2_transmission_id`, `branch`, `created_date`, `employee_count`, `transmission_file`, `w2_count`, `w2_delivery_address`, `client_type_id`, `delivery_code_type`) VALUES ('fedex-w2-id', 'southwest', '2022-10-15', '500', 'fedex-w2-files', '500', '154 S Rhein Rd', '3467', '3467');
