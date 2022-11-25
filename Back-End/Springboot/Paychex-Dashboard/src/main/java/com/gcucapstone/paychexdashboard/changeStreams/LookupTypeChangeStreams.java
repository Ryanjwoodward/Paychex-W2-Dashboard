package com.gcucapstone.paychexdashboard.changeStreams;

import com.gcucapstone.paychexdashboard.models.LookupType;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import static java.util.Collections.singletonList;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.changestream.FullDocument.UPDATE_LOOKUP;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.sql.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created) 11-10-2022
 * File:           | LookupTypeChangeStreams.java
 * Version:        | 1.0
 * Description:    | This file will be used to monitor changes to the Mongo
 *                 | Atlas Collection : LookupTypes
 * ---------------------------------------------------------------------------
 */
public class LookupTypeChangeStreams {

    ResultSet resultSet = null;
public LookupTypeChangeStreams(){

    ConnectionString connectionString = new ConnectionString(("mongodb+srv://pcd-user:pcd-capstone@cluster0.1bx6urb.mongodb.net/?retryWrites=true&w=majority"));
    CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
    CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
    MongoClientSettings clientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .codecRegistry(codecRegistry)
            .build();



    try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
        MongoDatabase db = mongoClient.getDatabase("PaychexDashboard");
        MongoCollection<LookupType> lookupTypes = db.getCollection("LookupType", LookupType.class);
        List<Bson> pipeline;

        pipeline = singletonList(match(eq("operationType", "update")));
/*
            lookupTypes.watch(pipeline).fullDocument(UPDATE_LOOKUP).forEach(printEvent());
*/
        lookupTypes.watch(pipeline).fullDocument(UPDATE_LOOKUP).forEach((d) -> {
            /*System.out.println("LOOKUP TYPE: " + d.getFullDocument().getLookupType());
            System.out.println("LOOKUP TYPE ID: " + d.getFullDocument().getLookupTypeID());*/

            com.gcucapstone.paychexdashboard.entity.LookupType lt_Entity =  new com.gcucapstone.paychexdashboard.entity.LookupType();
            lt_Entity.setLookupType(d.getFullDocument().getLookupType());
            lt_Entity.setLookupTypeId(d.getFullDocument().getLookupTypeID());

            submitQuery(lt_Entity);
        });

    }
}

    public void submitQuery(com.gcucapstone.paychexdashboard.entity.LookupType lookupType){


        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PaychexDashboard?createDatabaseIfNotExist=true", "acerbus", "bailey711");){


            String sqlQuery = "UPDATE `PaychexDashboard`.`lookup_types` SET `lookup_type` = ? WHERE (`lookup_type_id` = ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, lookupType.getLookupType());
            preparedStatement.setLong(2, lookupType.getLookupTypeId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}// LookupTypeChangeStreams Class




