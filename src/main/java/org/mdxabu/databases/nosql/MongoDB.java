package org.mdxabu.databases.nosql;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MongoDB {

    String collection_name = null;
    MongoClient mongoClient;
    MongoDatabase mongoDatabase;
    MongoCollection<Document> mongoCollection;
    private static final Logger logger = LoggerFactory.getLogger(MongoDB.class);

    public void setMongoConnectionString(String mongoConnectionString) {
        try {
            this.collection_name = mongoConnectionString;
            this.mongoClient = MongoClients.create(mongoConnectionString);
            logger.info("MongoDB connection established with connection string: {}", mongoConnectionString);
        } catch (Exception e) {
            logger.error("Failed to establish MongoDB connection", e);
        }
    }
    public String getMongoConnectionString() {
        if (this.mongoClient != null) {
            return this.collection_name;
        } else {
            return "No MongoDB connection established.";
        }
    }
    public void createMongoDatabase(String DatabaseName) {
        try {
            if (this.mongoClient != null && DatabaseName != null && !DatabaseName.isEmpty()) {
                this.mongoDatabase = this.mongoClient.getDatabase(DatabaseName);
                logger.info("Database '{}' created or accessed successfully", DatabaseName);
            } else {
                logger.error("Database name is null or empty, or MongoClient is not initialized.");
            }
        } catch (Exception e) {
            logger.error("Error while creating or accessing database {}", DatabaseName, e);
        }
    }
    public String getMongoDatabase() {
        if (this.mongoDatabase != null) {
            return this.mongoDatabase.getName();
        } else {
            return "No MongoDB database selected.";
        }
    }
    public void createMongoCollection(String CollectionName) {
        try {
            if (this.mongoDatabase != null && CollectionName != null && !CollectionName.isEmpty()) {
                this.mongoDatabase.createCollection(CollectionName);
                logger.info("Collection '{}' created successfully", CollectionName);
            } else {
                logger.error("Collection name is null or empty, So, We can't create a this collection");
            }
        } catch (Exception e) {
            logger.error("Error while creating collection {}", CollectionName);
        }
    }
}
