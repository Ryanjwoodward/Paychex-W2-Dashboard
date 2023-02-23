package com.gcucapstone.paychexdashboard.changeStreams;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)11-11-2022
 * File:           | AtlasConnectionTest.java
 * Version:        | 1.0
 * Description:    | This file is used to test the connection to the Mongo
 *                 | Atlas Cluster (cluster0)
 * ---------------------------------------------------------------------------
 */
public class AtlasConnectionTest {

    public static void main(String[] args) {
        String connectionString = "mongodb+srv://pcd-user:pcd-capstone@cluster0.1bx6urb.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
            databases.forEach(db -> System.out.println(db.toJson()));
        }
    }
}// AtlasConnctionTest Class
