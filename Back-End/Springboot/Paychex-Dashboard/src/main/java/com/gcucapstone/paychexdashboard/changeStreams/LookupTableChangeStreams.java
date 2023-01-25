package com.gcucapstone.paychexdashboard.changeStreams;

import com.gcucapstone.paychexdashboard.entity.LookupType;
import com.gcucapstone.paychexdashboard.models.LookupTable;
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
 * File:           | LookupTableChangeStreams.java
 * Version:        | 1.0
 * Description:    | This file will be used to monitor changes to the Mongo
 *                 | Atlas Collection : LookupTable
 * ---------------------------------------------------------------------------
 */
public class LookupTableChangeStreams extends Thread{

    @Override
    public void run(){

        ConnectionString connectionString = new ConnectionString(("mongodb+srv://pcd-user:pcd-capstone@cluster0.1bx6urb.mongodb.net/?retryWrites=true&w=majority"));
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).codecRegistry(codecRegistry).build();

        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase("PaychexDashboard");
            MongoCollection<LookupTable> lookupTables = db.getCollection("LookupTable", LookupTable.class);
            List<Bson> pipeline;

            lookupTables.watch(asList(Aggregates.match(Filters.in("operationType", asList("update","insert")))))
                    .fullDocument(UPDATE_LOOKUP).forEach((d) -> {

                        switch(d.getOperationTypeString()){

                            case "update":

                                System.out.println("****************************\n****************************\n****************************");
                                System.out.println("LOOKUPTABLE - Updated Doc: " + d.getFullDocument().toString());
                                System.out.println("****************************\n****************************\n****************************");

                                com.gcucapstone.paychexdashboard.entity.LookupTable lookupTable = new com.gcucapstone.paychexdashboard.entity.LookupTable();
                                lookupTable.setLookupId(d.getFullDocument().getLookupId());
                                lookupTable.setAbbreviation(d.getFullDocument().getAbbreviation());
                                lookupTable.setDescription(d.getFullDocument().getDescription());
                                lookupTable.setFullName(d.getFullDocument().getFullName());

                                submitUpdateQuery(lookupTable);

                                break;
                            case "insert":

                                System.out.println("****************************\n****************************\n****************************");
                                System.out.println("LOOKUPTABLE - Inserted Doc: " + d.getFullDocument().toString());
                                System.out.println("****************************\n****************************\n****************************");

                                lookupTable = new com.gcucapstone.paychexdashboard.entity.LookupTable();
                                LookupType lookupType = new LookupType();

                                lookupType.setLookupType(d.getFullDocument().getLookupTypeId().getLookupType());
                                lookupType.setLookupTypeId(d.getFullDocument().getLookupTypeId().getLookupTypeId());

                                lookupTable.setLookupId(d.getFullDocument().getLookupId());
                                lookupTable.setAbbreviation(d.getFullDocument().getAbbreviation());
                                lookupTable.setDescription(d.getFullDocument().getDescription());
                                lookupTable.setFullName(d.getFullDocument().getFullName());
                                lookupTable.setState(d.getFullDocument().getState());
                                lookupTable.setLookupTypeId(lookupType);

                                submitInsertQuery(lookupTable);

                                break;
                        }
                    });
        }
    }

    public void submitUpdateQuery(com.gcucapstone.paychexdashboard.entity.LookupTable lookupTable){

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PaychexDashboard?createDatabaseIfNotExist=true", "acerbus", "bailey711");){
            String sqlQuery = "UPDATE `PaychexDashboard`.`lookup_table` SET `lookup_abbreviation` = ? WHERE (`lookup_id` = ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, lookupTable.getAbbreviation());
            preparedStatement.setLong(2, lookupTable.getLookupId());
            preparedStatement.executeUpdate();

            sqlQuery = "UPDATE `PaychexDashboard`.`lookup_table` SET `lookup_description` = ? WHERE (`lookup_id` = ?);";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, lookupTable.getDescription());
            preparedStatement.setLong(2, lookupTable.getLookupId());
            preparedStatement.executeUpdate();

            sqlQuery = "UPDATE `PaychexDashboard`.`lookup_table` SET `lookup_full_name` = ? WHERE (`lookup_id` = ?);";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, lookupTable.getFullName());
            preparedStatement.setLong(2, lookupTable.getLookupId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void submitInsertQuery(com.gcucapstone.paychexdashboard.entity.LookupTable lookupTable){

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PaychexDashboard?createDatabaseIfNotExist=true", "acerbus", "bailey711");){

            //-- Add the Inserted Records Corresponding LookupType Record
            String sqlQuery2 = "INSERT INTO `PaychexDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES (?, ?);";
            PreparedStatement preparedStatement2 = connection.prepareStatement(sqlQuery2);
            preparedStatement2.setLong(1, lookupTable.getLookupTypeId().getLookupTypeId());
            preparedStatement2.setString(2, lookupTable.getLookupTypeId().getLookupType());

            //-- Insert the LookupTable Record
            String sqlQuery = "INSERT INTO `PaychexDashboard`.`lookup_table` (`lookup_id`, `lookup_abbreviation`, `lookup_description`, `lookup_full_name`, `state`, `lookup_type_id`) VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setLong(1, lookupTable.getLookupId());
            preparedStatement.setString(2, lookupTable.getAbbreviation());
            preparedStatement.setString(3, lookupTable.getDescription());
            preparedStatement.setString(4, lookupTable.getFullName());
            preparedStatement.setString(5, lookupTable.getState());
            preparedStatement.setLong(6, lookupTable.getLookupTypeId().getLookupTypeId());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}// LookupTableChangeStreams Class
