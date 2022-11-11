package com.gcucapstone.paychexdashboard.changeStreams;

import com.gcucapstone.paychexdashboard.models.LookupTable;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.changestream.ChangeStreamDocument;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import java.util.List;
import java.util.function.Consumer;

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

    public static void main(String[] args) {

        ConnectionString connectionString = new ConnectionString(("mongodb+srv://acerbus:bailey711@cluster0.n66xe.mongodb.net/test"));
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .build();

        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase("PaychexDashboard");
            MongoCollection<LookupTable> lookupTables = db.getCollection("lookupTables", LookupTable.class);
            List<Bson> pipeline;

            // Only uncomment one example at a time. Follow instructions for each individually then kill all remaining processes.

            /** => Example 1: print all the write operations.
             *  => Start "ChangeStreams" then "MappingPOJOs" to see some change events.
             */
            lookupTables.watch().forEach(printEvent());

            /** => Example 2: print only insert and delete operations.
             *  => Start "ChangeStreams" then "MappingPOJOs" to see some change events.
             */
            //pipeline = singletonList(match(in("operationType", asList("insert", "delete"))));
            //grades.watch(pipeline).forEach(printEvent());

            /** => Example 3: print only updates without fullDocument.
             *  => Start "ChangeStreams" then "Update" to see some change events (start "Create" before if not done earlier).
             */
            // pipeline = singletonList(match(eq("operationType", "update")));
            //grades.watch(pipeline).forEach(printEvent());

            /** => Example 4: print only updates with fullDocument.
             *  => Start "ChangeStreams" then "Update" to see some change events.
             */
            // pipeline = singletonList(match(eq("operationType", "update")));
            //grades.watch(pipeline).fullDocument(UPDATE_LOOKUP).forEach(printEvent());

            /**
             * => Example 5: iterating using a cursor and a while loop + remembering a resumeToken then restart the Change Streams.
             * => Start "ChangeStreams" then "Update" to see some change events.
             */
            // exampleWithResumeToken(grades);

        }
    }
    private static Consumer<ChangeStreamDocument<LookupTable>> printEvent() {
        return System.out::println;
    }

}// LookupTableChangeStreams Class
