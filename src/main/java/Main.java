/*
This class only for instant testing for all database.
 */


import org.mdxabu.databases.nosql.MongoDB;

public class Main {
    public static void main(String[] args) {

        String mongoConnectionString = "mongodb://localhost:27017";

        MongoDB mongoDB = new MongoDB();

        mongoDB.setMongoConnectionString(mongoConnectionString);

        String databaseName = "jdbctestingmongodb";

        mongoDB.createMongoDatabase(databaseName);
        System.out.println("Database: " + mongoDB.getMongoDatabase());

        String collectionName = "jdbctestingmongodbcollection";
        mongoDB.createMongoCollection(collectionName);


        System.out.println("MongoDB Connection String: " + mongoDB.getMongoConnectionString());
    }

}
