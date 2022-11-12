package com.gcucapstone.paychexdashboard.changeStreams;

import com.gcucapstone.paychexdashboard.models.LookupType;
import com.gcucapstone.paychexdashboard.repository.LookupTypeRepository;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.model.changestream.ChangeStreamDocument;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import static java.util.Collections.singletonList;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;

import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.changestream.FullDocument.UPDATE_LOOKUP;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.List;
import java.util.function.Consumer;

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

    @Autowired
    private static LookupTypeRepository lookupTypeRepository;
    private static com.gcucapstone.paychexdashboard.entity.LookupType lookupTypeE;
    private static List<com.gcucapstone.paychexdashboard.entity.LookupType> types;


    public static void main(String[] args) {

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
                System.out.println("LOOKUP TYPE: " + d.getFullDocument().getLookupType());
                System.out.println("LOOKUP TYPE ID: " + d.getFullDocument().getLookupTypeID());
                lookupTypeE = lookupTypeRepository.findByLookupTypeId(903999L);
                System.out.println("HERE: " + lookupTypeRepository == null);

                lookupTypeE.setLookupTypeId(d.getFullDocument().getLookupTypeID());
                lookupTypeE.setLookupType(d.getFullDocument().getLookupType());

                lookupTypeRepository.deleteById(d.getFullDocument().getLookupTypeID());
                lookupTypeRepository.save(lookupTypeE);
            });

            /*
            * When there is a change, have an autowired repo instance connected with sql that updates the info in SQL DB
             */

        }
    }
    private static Consumer<ChangeStreamDocument<LookupType>> printEvent() {
        return System.out::println;
    }
}// LookupTypeChangeStreams Class


