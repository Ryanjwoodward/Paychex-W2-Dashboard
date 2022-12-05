package com.gcucapstone.paychexdashboard.changeStreams;

import com.gcucapstone.paychexdashboard.entity.Carrier;
import com.gcucapstone.paychexdashboard.entity.Vendor;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
 * File:           | CarrierChangeStreams.java
 * Version:        | 1.0
 * Description:    | This file will be used to monitor changes to the Mongo
 *                 | Atlas Collection : Carrier
 * ---------------------------------------------------------------------------
 */
public class CarrierChangeStreams extends Thread{

    @Override
    public void run(){

        ConnectionString connectionString = new ConnectionString(("mongodb+srv://pcd-user:pcd-capstone@cluster0.1bx6urb.mongodb.net/?retryWrites=true&w=majority"));
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).codecRegistry(codecRegistry).build();

        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase("PaychexDashboard");
            MongoCollection<Carrier> carriers = db.getCollection("Carrier", Carrier.class);
            List<Bson> pipeline;

            pipeline = singletonList(match(eq("operationType", "update")));

            carriers.watch(pipeline).fullDocument(UPDATE_LOOKUP).forEach((d) -> {

                System.out.println("BC-CLIENT ID: " + d.getFullDocument().getCarrierId().getClientId());
                System.out.println("BC-BRANCH: " + d.getFullDocument().getCarrierId().getBranch());
                System.out.println("TRACK ID: " + d.getFullDocument().getTrackingId());

                Carrier carrier = new Carrier();
                carrier.setDestinationAddress(d.getFullDocument().getDestinationAddress());
                carrier.setTrackingId(d.getFullDocument().getTrackingId());
                carrier.setCarrierId(d.getFullDocument().getCarrierId());

                submitQuery(carrier);

            });
        }
    }

    public void submitQuery(Carrier carrier){

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PaychexDashboard?createDatabaseIfNotExist=true", "acerbus", "bailey711");){

            String sqlQuery = "UPDATE `PaychexDashboard`.`carrier` SET `destination_address` = ? WHERE (`branch` = ?) and (`client_id` = ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, carrier.getDestinationAddress());
            preparedStatement.setString(2, carrier.getCarrierId().getBranch());
            preparedStatement.setString(3, carrier.getCarrierId().getClientId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}//CarrierChangeStreams Class
