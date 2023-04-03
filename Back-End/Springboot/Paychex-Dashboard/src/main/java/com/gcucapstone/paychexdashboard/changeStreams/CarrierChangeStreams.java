package com.gcucapstone.paychexdashboard.changeStreams;

import com.gcucapstone.paychexdashboard.entity.BranchClient;
import com.gcucapstone.paychexdashboard.entity.Carrier;
import com.gcucapstone.paychexdashboard.entity.LookupTable;
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
 * File:           | CarrierChangeStreams.java
 * Version:        | 1.0
 * Description:    | This file will be used to monitor changes to the Mongo
 *                 | Atlas Collection : Carrier
 * ---------------------------------------------------------------------------
 */
public class CarrierChangeStreams extends Thread{

    @Override
    public void run(){

        ConnectionString connectionString = new ConnectionString(("mongodb+srv://ryangcu:UkfF5xsRobTil1Y6@cluster0.1bx6urb.mongodb.net/?retryWrites=true&w=majority"));
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).codecRegistry(codecRegistry).build();

        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase("PaychexDashboard");
            MongoCollection<Carrier> carriers = db.getCollection("Carrier", Carrier.class);
            List<Bson> pipeline;

            carriers.watch(asList(Aggregates.match(Filters.in("operationType", asList("update","insert")))))
                    .fullDocument(UPDATE_LOOKUP).forEach((d) -> {

                        switch(d.getOperationTypeString()){

                            case "update":

                                System.out.println("****************************\n****************************\n****************************");
                                System.out.println("CARRIER - Updated Doc: " + d.getFullDocument().toString());
                                System.out.println("****************************\n****************************\n****************************");

                                Carrier updatedCarrier = new Carrier();
                                updatedCarrier.setDestinationAddress(d.getFullDocument().getDestinationAddress());
                                updatedCarrier.setTrackingId(d.getFullDocument().getTrackingId());
                                updatedCarrier.setCarrierId(d.getFullDocument().getCarrierId());

                                submitUpdateQuery(updatedCarrier);
                                break;

                            case "insert":

                                System.out.println("****************************\n****************************\n****************************");
                                System.out.println("CARRIER - Inserted Doc: " + d.getFullDocument().toString());
                                System.out.println("****************************\n****************************\n****************************");

                                //Create Entity Objects
                                Carrier insertedCarrier = new Carrier();
                                LookupTable carrierLookupIdTable = new LookupTable();
                                LookupTable carrierDeliveryStatusTable = new LookupTable();

                                //CarrierLookupId Attribute
                                //Creates a LookupTable Obj and sets it values to those of the inserted document
                                carrierLookupIdTable.setAbbreviation(d.getFullDocument().getCarrierLookupId().getAbbreviation());
                                carrierLookupIdTable.setDescription(d.getFullDocument().getCarrierLookupId().getDescription());
                                carrierLookupIdTable.setLookupId(d.getFullDocument().getCarrierLookupId().getLookupId());
                                carrierLookupIdTable.setFullName(d.getFullDocument().getCarrierLookupId().getFullName());

                                //DeliveryStatusTypeId Attribute
                                //Creates a LookupTable Obj and sets it values to those of the inserted document
                                carrierDeliveryStatusTable.setAbbreviation(d.getFullDocument().getDeliveryStatusTypeId().getAbbreviation());
                                carrierDeliveryStatusTable.setDescription(d.getFullDocument().getDeliveryStatusTypeId().getDescription());
                                carrierDeliveryStatusTable.setLookupId(d.getFullDocument().getDeliveryStatusTypeId().getLookupId());
                                carrierDeliveryStatusTable.setFullName(d.getFullDocument().getDeliveryStatusTypeId().getFullName());

                                //Set the lone independent attributes od the Carrier entity from the inserted Mongo document
                                insertedCarrier.setDestinationAddress(d.getFullDocument().getDestinationAddress());
                                insertedCarrier.setTrackingId(d.getFullDocument().getTrackingId());
                                insertedCarrier.setCarrierId(new BranchClient(d.getFullDocument().getCarrierId().getBranch(),
                                        d.getFullDocument().getCarrierId().getClientId()));
                                insertedCarrier.setCarrierLookupId(carrierLookupIdTable);
                                insertedCarrier.setDeliveryStatusTypeId(carrierDeliveryStatusTable);


                                submitInsertQuery(insertedCarrier);
                                break;
                        }
                    });
        }
    }

    public void submitUpdateQuery(Carrier carrier){

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

    public void submitInsertQuery(Carrier carrier){

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PaychexDashboard?createDatabaseIfNotExist=true", "acerbus", "bailey711");){


            System.out.println("INSCAR: BRANCH-" + carrier.getCarrierId().getBranch());
            System.out.println("INSCAR: CLIENT-" + carrier.getCarrierId().getClientId());
            System.out.println("INSCAR: DESTAD-" + carrier.getTrackingId());
            System.out.println("INSCAR: TRACID-" + carrier.getTrackingId());
            System.out.println("INSCAR: CLUPID-" + carrier.getCarrierLookupId().getLookupId());
            System.out.println("INSCAR: DLSTID-" + carrier.getDeliveryStatusTypeId().getLookupId());


            String sqlQuery = "INSERT INTO `PaychexDashboard`.`carrier` (`branch`, `client_id`, `destination_address`, `tracking_id`, `carrier_lookup_id`, `delviery_status_type_id`) VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, carrier.getCarrierId().getBranch());
            preparedStatement.setString(2, carrier.getCarrierId().getClientId());
            preparedStatement.setString(3, carrier.getDestinationAddress());
            preparedStatement.setString(4, carrier.getTrackingId());
            preparedStatement.setLong(5, carrier.getCarrierLookupId().getLookupId());
            preparedStatement.setLong(6, carrier.getDeliveryStatusTypeId().getLookupId());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}//CarrierChangeStreams Class
