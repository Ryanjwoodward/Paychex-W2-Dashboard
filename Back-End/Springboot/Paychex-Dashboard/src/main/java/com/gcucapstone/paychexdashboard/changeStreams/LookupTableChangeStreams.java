package com.gcucapstone.paychexdashboard.changeStreams;

import com.gcucapstone.paychexdashboard.models.LookupTable;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.changestream.ChangeStreamDocument;
import com.mongodb.client.model.changestream.FullDocument;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;

import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.changestream.FullDocument.UPDATE_LOOKUP;
import static java.util.Collections.singletonList;
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
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .build();

        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase("PaychexDashboard");
            MongoCollection<LookupTable> lookupTables = db.getCollection("LookupTable", LookupTable.class);
            List<Bson> pipeline;

            pipeline = singletonList(match(eq("operationType", "update")));

            lookupTables.watch(pipeline).fullDocument(UPDATE_LOOKUP).forEach((d) ->{
                System.out.println("LOOKUP ID: " + d.getFullDocument().getLookupId());
                System.out.println("LOOKUP TYPE ID: " + d.getFullDocument().getLookupTypeId());
                System.out.println("ABBREV: " + d.getFullDocument().getAbbreviation());
                System.out.println("DESCR: " + d.getFullDocument().getDescription());
                System.out.println("FULL NAME: " + d.getFullDocument().getFullName());

                com.gcucapstone.paychexdashboard.entity.LookupTable lt_Entity = new com.gcucapstone.paychexdashboard.entity.LookupTable();
                lt_Entity.setLookupId(d.getFullDocument().getLookupId());
                lt_Entity.setAbbreviation(d.getFullDocument().getAbbreviation());
                lt_Entity.setDescription(d.getFullDocument().getDescription());
                lt_Entity.setFullName(d.getFullDocument().getFullName());

                submitQuery(lt_Entity);
            });
        }
    }

    public void submitQuery(com.gcucapstone.paychexdashboard.entity.LookupTable lookupTable){

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

}// LookupTableChangeStreams Class
