package com.gcucapstone.paychexdashboard.changeStreams;

import com.gcucapstone.paychexdashboard.entity.Client;
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

import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.changestream.FullDocument.UPDATE_LOOKUP;
import static java.util.Arrays.asList;
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

        ConnectionString connectionString = new ConnectionString(("mongodb+srv://ryangcu:UkfF5xsRobTil1Y6@cluster0.1bx6urb.mongodb.net/?retryWrites=true&w=majority"));
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).codecRegistry(codecRegistry).build();

        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase("PaychexDashboard");
            MongoCollection<Client> clients = db.getCollection("Client", Client.class);
            List<Bson> pipeline;

            clients.watch(asList(Aggregates.match(Filters.in("operationType", asList("update","insert")))))
                    .fullDocument(UPDATE_LOOKUP).forEach((d) -> {

                switch(d.getOperationTypeString()){

                    case "update":

                        System.out.println("****************************\n****************************\n****************************");
                        System.out.println("CLIENT - Updated Doc: " + d.getFullDocument().toString());
                        System.out.println("****************************\n****************************\n****************************");


                        Client client = new Client();
                        client.setW2TransmissionId(d.getFullDocument().getW2TransmissionId());
                        client.setBranch(d.getFullDocument().getBranch());
                        client.setEmployeeCount(d.getFullDocument().getEmployeeCount());
                        client.setTransmissionFile(d.getFullDocument().getTransmissionFile());
                        client.setW2Count(d.getFullDocument().getW2Count());
                        client.setW2DeliveryAddress(d.getFullDocument().getW2DeliveryAddress());

                        submitUpdateQuery(client, d.getFullDocument().getClientTypeId().getLookupId(), d.getFullDocument().getDeliveryCodeTypeId().getLookupId());
                        break;

                    case "insert":

                        System.out.println("****************************\n****************************\n****************************");
                        System.out.println("CLIENT - Inserted Doc: " + d.getFullDocument().toString());
                        System.out.println("****************************\n****************************\n****************************");

                        Client client1 = new Client();
                        client1.setW2TransmissionId(d.getFullDocument().getW2TransmissionId());
                        client1.setBranch(d.getFullDocument().getBranch());
                        client1.setCreatedDate(d.getFullDocument().getCreatedDate());
                        client1.setEmployeeCount(d.getFullDocument().getEmployeeCount());
                        client1.setTransmissionFile(d.getFullDocument().getTransmissionFile());
                        client1.setW2Count(d.getFullDocument().getW2Count());
                        client1.setW2DeliveryAddress(d.getFullDocument().getW2DeliveryAddress());

                        submitInsertQuery(client1, d.getFullDocument().getClientTypeId().getLookupId(), d.getFullDocument().getDeliveryCodeTypeId().getLookupId());
                        break;
                }
            });
        }
    }

    public void submitUpdateQuery(Client client, Long clientLookupId, Long deliveryCodeLookupId){

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PaychexDashboard?createDatabaseIfNotExist=true", "acerbus", "bailey711");){

            String sqlQueryF = "UPDATE `PaychexDashboard`.`client` SET  `branch` = ?, `created_date` = ?, `employee_count` = ?, `transmission_file` = ?, `w2_count` = ?, `w2_delivery_address` = ?, `client_type_id` = ?, `delivery_code_type` = ? WHERE (`w2_transmission_id` = ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQueryF);
            preparedStatement.setString(1, client.getBranch());
            preparedStatement.setString(2, client.getCreatedDate());
            preparedStatement.setInt(3, client.getEmployeeCount());
            preparedStatement.setString(4, client.getTransmissionFile());
            preparedStatement.setInt(5, client.getW2Count());
            preparedStatement.setString(6, client.getW2DeliveryAddress());
            preparedStatement.setLong(7, clientLookupId);
            preparedStatement.setLong(8, deliveryCodeLookupId);
            preparedStatement.setString(9, client.getW2TransmissionId());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public void submitInsertQuery(Client client, Long clientLookupId, Long deliveryCodeLookupId){

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PaychexDashboard?createDatabaseIfNotExist=true", "acerbus", "bailey711");){

            String sqlQuery = "INSERT INTO `PaychexDashboard`.`client` (`w2_transmission_id`, `branch`, `created_date`, `employee_count`, `transmission_file`, `w2_count`, `w2_delivery_address`, `client_type_id`, `delivery_code_type`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, client.getW2TransmissionId());
            preparedStatement.setString(2, client.getBranch());
            preparedStatement.setString(3, client.getCreatedDate());
            preparedStatement.setInt(4, client.getEmployeeCount());
            preparedStatement.setString(5, client.getTransmissionFile());
            preparedStatement.setInt(6, client.getW2Count());
            preparedStatement.setString(7, client.getW2DeliveryAddress());
            preparedStatement.setLong(8, clientLookupId);
            preparedStatement.setLong(9, deliveryCodeLookupId);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}// ClientChangeStreams
