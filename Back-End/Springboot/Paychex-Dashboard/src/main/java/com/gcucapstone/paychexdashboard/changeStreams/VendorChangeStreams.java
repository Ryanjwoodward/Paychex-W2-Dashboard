package com.gcucapstone.paychexdashboard.changeStreams;

import com.gcucapstone.paychexdashboard.entity.LookupType;
import com.gcucapstone.paychexdashboard.entity.Vendor;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.changestream.FullDocument.UPDATE_LOOKUP;
import static java.util.Arrays.asList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created) 11-10-2022
 * File:           | VendorChangeStreams.java
 * Version:        | 1.0
 * Description:    | This file will be used to monitor changes to the Mongo
 *                 | Atlas Collection : Vendor
 * ---------------------------------------------------------------------------
 */
public class VendorChangeStreams extends Thread{

    @Override
    public void run(){

        ConnectionString connectionString = new ConnectionString(("mongodb+srv://ryangcu:UkfF5xsRobTil1Y6@cluster0.1bx6urb.mongodb.net/?retryWrites=true&w=majority"));
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).codecRegistry(codecRegistry).build();

        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase("PaychexDashboard");
            MongoCollection<Vendor> vendors = db.getCollection("Vendor", Vendor.class);
            List<Bson> pipeline;

            vendors.watch(asList(Aggregates.match(Filters.in("operationType", asList("update","insert")))))
                    .fullDocument(UPDATE_LOOKUP).forEach((d) -> {

                        switch(d.getOperationTypeString()){
                             case "update":
                                 System.out.println("****************************\n****************************\n****************************");
                                 System.out.println("VENDROR - Updated Doc: " + d.getFullDocument().toString());
                                 System.out.println("****************************\n****************************\n****************************");


                                 Vendor vendor = new Vendor();
                                vendor.setVendorId(d.getFullDocument().getVendorId());
                                vendor.setEmployeeCount(d.getFullDocument().getEmployeeCount());
                                vendor.setW2Count(d.getFullDocument().getW2Count());

                                submitUpdateQuery(vendor);
                             break;
                            case "insert":

                                System.out.println("****************************\n****************************\n****************************");
                                System.out.println("VENDOR - Inserted Doc: " + d.getFullDocument().toString());
                                System.out.println("****************************\n****************************\n****************************");

                                Vendor vendor1 = new Vendor();
                                vendor1.setVendorId(d.getFullDocument().getVendorId());
                                vendor1.setEmployeeCount(d.getFullDocument().getEmployeeCount());
                                vendor1.setW2Count(d.getFullDocument().getW2Count());
                                vendor1.setLookupId(d.getFullDocument().getLookupId());

                                submitInsertQuery(vendor1);
                                break;
                        }
                    });
        }
    }

    public void submitUpdateQuery(Vendor vendor){

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PaychexDashboard?createDatabaseIfNotExist=true", "acerbus", "bailey711");){

            //
            String sqlQuery = "UPDATE `PaychexDashboard`.`vendor` SET `vendor_employee_count` = ? WHERE (`branch` = ?) and (`client_id` = ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, vendor.getEmployeeCount());
            preparedStatement.setString(2, vendor.getVendorId().getBranch());
            preparedStatement.setString(3, vendor.getVendorId().getClientId());
            preparedStatement.executeUpdate();

            sqlQuery = "UPDATE `PaychexDashboard`.`vendor` SET `vendor_w2_count` = ? WHERE (`branch` = ?) and (`client_id` = ?);";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, vendor.getW2Count());
            preparedStatement.setString(2, vendor.getVendorId().getBranch());
            preparedStatement.setString(3, vendor.getVendorId().getClientId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void submitInsertQuery(Vendor vendor){

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PaychexDashboard?createDatabaseIfNotExist=true", "acerbus", "bailey711");){

            //-- Insert a new record into the MySQL DB that matches the newly inserted record of the MongoDB Colleciton
            String sqlQuery3 = "INSERT INTO `PaychexDashboard`.`vendor` (`branch`, `client_id`, `vendor_employee_count`, `vendor_w2_count`, `vendor_lookup_id`) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement3 = connection.prepareStatement(sqlQuery3);
            preparedStatement3.setString(1, vendor.getVendorId().getBranch());
            preparedStatement3.setString(2, vendor.getVendorId().getClientId());
            preparedStatement3.setInt(3, vendor.getEmployeeCount());
            preparedStatement3.setInt(4, vendor.getW2Count());
            preparedStatement3.setLong(5, vendor.getLookupId().getLookupId());
            preparedStatement3.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}// VendorChangeStreams
