package org.mdxabu.databases.nosql;

import com.mongodb.client.MongoClient;
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

    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public MongoDatabase getDb() {
        return db;
    }

    public void setDb(MongoDatabase db) {
        this.db = db;
    }
}
