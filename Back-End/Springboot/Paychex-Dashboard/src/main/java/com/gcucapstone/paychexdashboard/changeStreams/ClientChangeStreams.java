package com.gcucapstone.paychexdashboard.changeStreams;

import com.gcucapstone.paychexdashboard.entity.Client;
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
 * File:           | VendorChangeStreams.java
 * Version:        | 1.0
 * Description:    | This file will be used to monitor changes to the Mongo
 *                 | Atlas Collection : Client
 * ---------------------------------------------------------------------------
 */
public class ClientChangeStreams extends Thread{

    @Override
    public void run(){

        ConnectionString connectionString = new ConnectionString(("mongodb+srv://pcd-user:pcd-capstone@cluster0.1bx6urb.mongodb.net/?retryWrites=true&w=majority"));
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).codecRegistry(codecRegistry).build();

        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase("PaychexDashboard");
            MongoCollection<Client> clients = db.getCollection("Client", Client.class);
            List<Bson> pipeline;

            pipeline = singletonList(match(eq("operationType", "update")));

            clients.watch(pipeline).fullDocument(UPDATE_LOOKUP).forEach((d) ->{

                System.out.println("BRANCH: " + d.getFullDocument().getBranch());
                System.out.println("TRMSN FILE: " + d.getFullDocument().getTransmissionFile());
                System.out.println("EMP COUNT: " + d.getFullDocument().getEmployeeCount());
                System.out.println("W2 TRMSN ID: " + d.getFullDocument().getW2TransmissionId());
                System.out.println("CLIENT TYPE ID: " + d.getFullDocument().getClientTypeId());

                Client client = new Client();
                client.setW2TransmissionId(d.getFullDocument().getW2TransmissionId());
                client.setBranch(d.getFullDocument().getBranch());
                client.setEmployeeCount(d.getFullDocument().getEmployeeCount());
                client.setTransmissionFile(d.getFullDocument().getTransmissionFile());
                client.setW2Count(d.getFullDocument().getW2Count());
                client.setW2DeliveryAddress(d.getFullDocument().getW2DeliveryAddress());

                submitQuery(client);
            });
        }
    }

    public void submitQuery(Client client){

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PaychexDashboard?createDatabaseIfNotExist=true", "acerbus", "bailey711");){

            String sqlQuery = "UPDATE `PaychexDashboard`.`client` SET `branch` = ? WHERE (`w2_transmission_id` = ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, client.getBranch());
            preparedStatement.setString(2, client.getW2TransmissionId());
            preparedStatement.executeUpdate();

            sqlQuery = "UPDATE `PaychexDashboard`.`client` SET `employee_count` = ? WHERE (`w2_transmission_id` = ?);";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, client.getEmployeeCount());
            preparedStatement.setString(2, client.getW2TransmissionId());
            preparedStatement.executeUpdate();

            sqlQuery = "UPDATE `PaychexDashboard`.`client` SET `transmission_file` = ? WHERE (`w2_transmission_id` = ?);";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, client.getTransmissionFile());
            preparedStatement.setString(2, client.getW2TransmissionId());
            preparedStatement.executeUpdate();

            sqlQuery = "UPDATE `PaychexDashboard`.`client` SET `w2_count` = ? WHERE (`w2_transmission_id` = ?);";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, client.getW2Count());
            preparedStatement.setString(2, client.getW2TransmissionId());
            preparedStatement.executeUpdate();

            sqlQuery = "UPDATE `PaychexDashboard`.`client` SET `w2_delivery_address` = ? WHERE (`w2_transmission_id` = ?);";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, client.getW2DeliveryAddress());
            preparedStatement.setString(2, client.getW2TransmissionId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}// ClientChangeStreams
