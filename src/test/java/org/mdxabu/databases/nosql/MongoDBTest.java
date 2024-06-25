package org.mdxabu.databases.nosql;

import org.bson.Document;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;

public class MongoDBTest {

    private MongoDB mongoDB;

    @BeforeEach
    public void setUp() {
        mongoDB = new MongoDB();
        mongoDB.setMongoConnectionString("mongodb://localhost:27017");
    }

    @AfterEach
    public void tearDown() {
        mongoDB.deleteMongoDatabase("testDB");
    }

    @Test
    public void testCreateMongoDatabase() {
        mongoDB.createMongoDatabase("testDB");
        String dbName = mongoDB.getMongoDatabase();
        assertEquals("testDB", dbName);
    }

    @Test
    public void testCreateMongoCollection() {
        mongoDB.createMongoDatabase("testDB");
        mongoDB.createMongoCollection("testCollection");
        assertNotNull(mongoDB.mongoDatabase.getCollection("testCollection"));
    }

    @Test
    public void testDeleteMongoCollection() {
        mongoDB.createMongoDatabase("testDB");
        mongoDB.createMongoCollection("testCollection");
        mongoDB.deleteMongoCollection("testCollection");
    }

    @Test
    public void testInsertOneDocument() {
        mongoDB.createMongoDatabase("testDB");
        mongoDB.createMongoCollection("testCollection");
        Document document = new Document("name", "John Doe").append("age", 30);
        mongoDB.insertOneDocument("testCollection", document);
        Document retrievedDocument = mongoDB.mongoDatabase.getCollection("testCollection").find().first();
        assertNotNull(retrievedDocument);
        assertEquals("John Doe", retrievedDocument.getString("name"));
        assertEquals(30, retrievedDocument.getInteger("age"));
    }

    @Test
    public void testInsertManyDocuments() {
        mongoDB.createMongoDatabase("testDB");
        mongoDB.createMongoCollection("testCollection");
        Document doc1 = new Document("name", "Alice").append("age", 25);
        Document doc2 = new Document("name", "Bob").append("age", 28);
        mongoDB.insertManyDocuments("testCollection", Arrays.asList(doc1, doc2));
        long count = mongoDB.mongoDatabase.getCollection("testCollection").countDocuments();
        assertEquals(2, count);
    }
}
