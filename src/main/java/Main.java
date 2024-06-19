/*
This class only for instant testing for all database.
 */


import org.mdxabu.databases.mysql.MySQL;
import org.mdxabu.databases.nosql.MongoDB;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        MySQL db = new MySQL();
        db.setENDPOINT("localhost");
        db.setPORT("3306");
        db.setCredentials("root", "password");
        db.start();
        db.useDatabase("jdbctesting");
        Map<String,String> user = new HashMap<>();
        user.put("username", "   VARCHAR(20)");
        user.put("password", "VARCHAR(20)");
        user.put("age", "INT");
        db.createTable("users",user);

    }

}
