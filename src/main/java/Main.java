/*
This class only for instant testing for all database.
 */


import org.mdxabu.databases.nosql.MongoDB;

public class Main {
    public static void main(String[] args) {
        MongoDB mongo = new MongoDB();
        mongo.setMongoClient("mongodb://localhost:27017/");
        mongo.createDatabase("testjdbcdb");

    }

}
