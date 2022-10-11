/*Create the Database for Dashboard*/
CREATE SCHEMA `PaychexW2Dashboard` ;

/* Create the first table 'lookup_types' */
CREATE TABLE `PaychexW2Dashboard`.`lookup_types` (
  `lookup_type_id` INT NOT NULL,
  PRIMARY KEY (`lookup_type_id`));
  
/* Create table 'lookup_table' which has a foreign key in 'lookup_types' table*/
CREATE TABLE `PaychexW2Dashboard`.`lookup_table` (
  `lookup_id` INT NOT NULL,
  `lookup_abbreviation` VARCHAR(45) NULL,
  `lookup_description` VARCHAR(45) NULL,
  `lookup_full_name` VARCHAR(45) NULL,
  `lookup_type_id` INT NULL,
  PRIMARY KEY (`lookup_id`),
  INDEX `lookup_type_id_idx` (`lookup_type_id` ASC) VISIBLE,
  CONSTRAINT `lookup_type_id`
    FOREIGN KEY (`lookup_type_id`)
    REFERENCES `PaychexW2Dashboard`.`lookup_types` (`lookup_type_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
/* Create table 'W2_carrier_information' which has 2 foreign keys in 'lookup_table' */
CREATE TABLE `PaychexW2Dashboard`.`W2_carrier_information` (
  `branch` VARCHAR(50) NOT NULL,
  `client_id` VARCHAR(45) NOT NULL,
  `destination_address` VARCHAR(45) NULL,
  `tracking_id` VARCHAR(45) NULL,
  `carrier_type` INT NULL,
  `delivery_status_type` INT NULL,
  PRIMARY KEY (`branch`, `client_id`),
  INDEX `lookup_id_idx` (`carrier_type` ASC) VISIBLE,
  INDEX `lookup_id_dt_idx` (`delivery_status_type` ASC) VISIBLE,
  CONSTRAINT `lookup_id_ct`
    FOREIGN KEY (`carrier_type`)
    REFERENCES `PaychexW2Dashboard`.`lookup_table` (`lookup_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `lookup_id_dt`
    FOREIGN KEY (`delivery_status_type`)
    REFERENCES `PaychexW2Dashboard`.`lookup_table` (`lookup_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
/* Create table 'W2_client_tng table' which has 2 foreign keys in 'lookup' table */
CREATE TABLE `PaychexW2Dashboard`.`W2_client_tng` (
  `W2_transmission_id` VARCHAR(45) NOT NULL,
  `branch` VARCHAR(45) NULL,
  `created_date` TIMESTAMP NULL,
  `tng_employee_count` INT NULL,
  `transmission_file` VARCHAR(45) NULL,
  `tng_W2_count` INT NULL,
  `W2_delivery_address` VARCHAR(60) NULL,
  `client_type_id` INT NULL,
  `delivery_code_type` INT NULL,
  PRIMARY KEY (`W2_transmission_id`),
  INDEX `lookup_id_ct_idx` (`client_type_id` ASC) VISIBLE,
  INDEX `lookup_id_dt_idx` (`delivery_code_type` ASC) VISIBLE,
  CONSTRAINT `lookup_id_cti`
    FOREIGN KEY (`client_type_id`)
    REFERENCES `PaychexW2Dashboard`.`lookup_table` (`lookup_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `lookup_id_dct`
    FOREIGN KEY (`delivery_code_type`)
    REFERENCES `PaychexW2Dashboard`.`lookup_table` (`lookup_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

/* Create table 'PW2_vendor_information' which has 1 foreign column in 'lookup_table' */
CREATE TABLE `PaychexW2Dashboard`.`W2_vendor_information` (
  `branch` VARCHAR(45) NOT NULL,
  `client_id` VARCHAR(45) NOT NULL,
  `vendor_employee_count` INT NULL,
  `vendor_W2_count` INT NULL,
  `W2_vendor_type` INT NULL,
  PRIMARY KEY (`branch`, `client_id`),
  INDEX `lookup_id_vt_idx` (`W2_vendor_type` ASC) VISIBLE,
  CONSTRAINT `lookup_id_vt`
    FOREIGN KEY (`W2_vendor_type`)
    REFERENCES `PaychexW2Dashboard`.`lookup_table` (`lookup_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
  
