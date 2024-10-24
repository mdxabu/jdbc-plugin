package com.mongodb.jdbcplugin;

import com.jdbcplugin.utils.nosql.MongoConnectionMananger;
import com.jdbcplugin.utils.sql.ConnectionMananger;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;


public class MongoDBConnectionManager implements MongoConnectionMananger {

    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private String ConnectionString;


    @Override
    public void setCredentials(String username, String password) {

    }

    @Override
    public void connect(String URL) {
        ConnectionString = URL;
        mongoClient = MongoClients.create(URL);
        System.out.println(URL!=null?"MongoDB was Connected!":"MongoDB was not Connected! Check your ConnectionString.");

    }

    @Override
    public void disconnect() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

    @Override
    public boolean isConnected() {
        try {
            if (mongoClient == null) {
                return false;
            }
            Document pingResult = mongoClient.getDatabase("admin").runCommand(new Document("ping", 1));
            return pingResult.getDouble("ok").equals(1.0);
        } catch (Exception e) {

            return false;
        }
    }

    @Override
    public void createDatabase(String databaseName) {
        mongoDatabase = mongoClient.getDatabase(databaseName);
        System.out.println(mongoDatabase!=null?databaseName+" was Created!":databaseName+" was not Created!");
    }

    @Override
    public void useDatabase(String databaseName) {
        mongoDatabase = mongoClient.getDatabase(databaseName);
    }

    @Override
    public void createCollection(String collectionName) {
        mongoDatabase.createCollection(collectionName);
        mongoDatabase.getCollection(collectionName);
        System.out.println(collectionName+" was Created!");
    }

    @Override
    public void dropCollection(String collectionName) {
        mongoDatabase.getCollection(collectionName).drop();
        System.out.println(collectionName+" was Dropped!");
    }


    @Override
    public void deleteDatabase(String databaseName) {
        mongoClient.getDatabase(databaseName).drop();
        mongoDatabase = null;
        System.out.println(databaseName+" was Deleted!");
    }

    @Override
    public void insertOne(Document document, String collectionName) {
        if (mongoDatabase != null) {
            mongoDatabase.getCollection(collectionName).insertOne(document);
            System.out.println(collectionName+" was Inserted!");
        } else {
            throw new IllegalStateException("Database not selected.");
        }

    }



    @Override
    public void insertMany(ArrayList<Document> document, String collectionName) {
        if (mongoDatabase != null) {
            mongoDatabase.getCollection(collectionName).insertMany(document);
            System.out.println(collectionName+" was Inserted!");
        } else {
            throw new IllegalStateException("Database not selected.");
        }
    }
}
