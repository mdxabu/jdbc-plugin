/*
This class only for instant testing for all database.
 */


import org.bson.Document;
import org.mdxabu.databases.nosql.MongoDB;

public class Main {
    public static void main(String[] args) {

        String mongoConnectionString = "mongodb://localhost:27017";

        MongoDB mongoDB = new MongoDB();

        mongoDB.setMongoConnectionString(mongoConnectionString);

        mongoDB.createMongoDatabase("user-data");
        mongoDB.createMongoCollection("users");

        Document doc = new Document("name","abu")
                .append("age",20)
                .append("place","India");

        mongoDB.insertOneDocument("users",doc);

        System.out.println(mongoDB.getMongoDatabase());

        mongoDB.deleteMongoCollection("users");
        mongoDB.deleteMongoDatabase("user-data");
        System.out.println(mongoDB.getMongoDatabase());
    }

}
