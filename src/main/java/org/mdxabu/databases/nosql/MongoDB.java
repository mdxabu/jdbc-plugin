package org.mdxabu.databases.nosql;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDB {

    String ConnectionString;
    MongoClient mongoClient;
    MongoDatabase db;

    public void setConnectionString(String connectionstring) {
        this.ConnectionString = connectionstring;
    }
    public String getConnectionString() {
        return this.ConnectionString;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public void setMongoClient(String connectionstring) {
        this.mongoClient = MongoClients.create(connectionstring);
    }

    public void createDatabase(String databaseName) {
        db = this.mongoClient.getDatabase(databaseName);
    }




}
