package org.mdxabu.databases.nosql;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.mdxabu.databases.run.run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MongoDB {

    String collection_name = null;
    MongoClient mongoClient;
    MongoDatabase mongoDatabase;
    MongoCollection<Document> mongoCollection;
    private static final Logger logger = LoggerFactory.getLogger(MongoDB.class);


    public MongoDB() {
        run asciitext = new run();
    }

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
    public String getMongoDatabase() {
        if (this.mongoDatabase != null) {
            return this.mongoDatabase.getName();
        } else {
            return "There is no Database in that name.";
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
    public void deleteMongoDatabase(String DatabaseName) {
        try{
            if (this.mongoClient != null && DatabaseName != null && !DatabaseName.isEmpty()) {
                this.mongoDatabase = this.mongoClient.getDatabase(DatabaseName);
                this.mongoDatabase.drop();
                this.mongoDatabase = null;
                logger.info("Database '{}' deleted successfully", DatabaseName);
            }
            else {
                logger.error("Database name is null or Check the Database name correctly to delete.");
            }
        }
        catch (Exception e) {
            logger.error("Error while deleting or accessing database {}", DatabaseName);
        }
    }
    public void createMongoCollection(String CollectionName) {
        try {
            if (this.mongoDatabase != null && CollectionName != null && !CollectionName.isEmpty()) {
                this.mongoDatabase.createCollection(CollectionName);
                logger.info("Collection '{}' created successfully", CollectionName);
            } else {
                logger.error("Collection name is null or empty, So, We can't create a this collection.");
            }
        } catch (Exception e) {
            logger.error("Error while creating collection {}", CollectionName);
        }
    }

    public void deleteMongoCollection(String CollectionName) {
        try {
            if (this.mongoDatabase != null && CollectionName != null && !CollectionName.isEmpty()) {
                this.mongoCollection= this.mongoDatabase.getCollection(CollectionName);
                this.mongoCollection.drop();
                this.mongoCollection = null;
                logger.info("Collection '{}' deleted successfully", CollectionName);
            } else {
                logger.error("Collection name is null or empty, or MongoDatabase is not selected.");
            }
        } catch (Exception e) {
            logger.error("Error while deleting collection {}", CollectionName, e);
        }
    }

    public void insertOneDocument(String CollectionName, Document document){
        try{
            if (this.mongoDatabase != null && CollectionName != null && !CollectionName.isEmpty() && !document.isEmpty()) {
                this.mongoCollection = this.mongoDatabase.getCollection(CollectionName);
                this.mongoCollection.insertOne(document);
                logger.info("Document inserted successfully");
            }
            else{
                logger.error("Database, Collection, or Document is empty! Check Correctly to insert.");
            }
        }
        catch (Exception e){
            logger.error("Error while inserting document", e);
        }
    }
}
