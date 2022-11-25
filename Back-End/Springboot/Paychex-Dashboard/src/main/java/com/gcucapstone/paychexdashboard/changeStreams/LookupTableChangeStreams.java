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
public class LookupTableChangeStreams {

    public LookupTableChangeStreams(){

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

            lookupTables.watch(pipeline).fullDocument(UPDATE_LOOKUP).forEach((t) ->{
                System.out.println("Lookup ID: " + t.getFullDocument().getLookupId());
                System.out.println("ABBREV: " + t.getFullDocument().getAbbreviation());
                System.out.println("DESCR: " + t.getFullDocument().getDescription());
                System.out.println("FULLNAME: " + t.getFullDocument().getFullName());
                System.out.println("LUID-TYPE: :" + t.getFullDocument().getLookupTypeId().getLookupType());
            });

        }
    }




    //------------------------
    //For Testing Purposes
    //------------------------
    /*private  Consumer<ChangeStreamDocument<LookupTable>> printEvent() {
        return System.out::println;
    }
*/
}// LookupTableChangeStreams Class
