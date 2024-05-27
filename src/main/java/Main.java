/*
This class only for instant testing for all database.
 */


import org.mdxabu.databases.mysql.MySQL;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MySQL mySQL = new MySQL();
        mySQL.setCredentials("root", "password");
        mySQL.setENDPOINT("localhost");
        mySQL.setPORT("3306");
        try {
            mySQL.start();
            mySQL.useDatabase("testdbforjdbcplugin");

            Map<String, String> columns = new HashMap<>();
            columns.put("id", "INT PRIMARY KEY AUTO_INCREMENT");
            columns.put("name", "VARCHAR(255)");
            columns.put("email", "VARCHAR(255)");

            mySQL.createTable("users",columns);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
