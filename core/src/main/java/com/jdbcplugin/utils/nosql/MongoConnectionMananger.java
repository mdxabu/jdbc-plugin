package com.jdbcplugin.utils.nosql;

import org.bson.Document;

import java.util.ArrayList;

public interface MongoConnectionMananger {

    public void setCredentials(String username, String password);

    public void connect(String URL);

    public void disconnect();

    public boolean isConnected();

    public void createDatabase(String databaseName);

    public void useDatabase(String databaseName);

    public void createCollection(String collectionName);

    public void dropCollection(String collectionName);

    public void deleteDatabase(String databaseName);

    public void insertOne(Document document, String collectionName);

    public void insertMany(ArrayList<Document> document, String collectionName);

}
