/*
This class only for instant testing for all database.
 */


import org.bson.Document;
import org.mdxabu.databases.nosql.MongoDB;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String mongoConnectionString = "mongodb://localhost:27017";

        MongoDB mongoDB = new MongoDB();

        mongoDB.setMongoConnectionString(mongoConnectionString);



        mongoDB.deleteMongoCollection("users");
        mongoDB.deleteMongoDatabase("user-data");
        System.out.println(mongoDB.getMongoDatabase());
    }

}
