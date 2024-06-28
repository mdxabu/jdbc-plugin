package org.mdxabu.databases.mysql;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MySQLTest {

    private MySQL mySQL;

    @BeforeEach
    public void setUp() throws ClassNotFoundException, SQLException {
        mySQL = new MySQL();
        mySQL.setCredentials("root", "password");
        mySQL.setENDPOINT("localhost");
        mySQL.setPORT("3306");
        mySQL.start();
        mySQL.createDatabase("testDB");
        mySQL.useDatabase();
    }

    @AfterEach
    public void tearDown() throws SQLException {
        mySQL.deleteDatabase("testDB");
    }

    @Test
    public void testCreateDatabase() throws SQLException {
        mySQL.createDatabase("anotherTestDB");
        String dbName = mySQL.getDatabase();
        assertEquals("anotherTestDB", dbName);
        mySQL.deleteDatabase("anotherTestDB");
    }

    @Test
    public void testCreateTable() throws SQLException, ClassNotFoundException {

        Map<String, String> columns = new HashMap<>();
        columns.put("id", "INT PRIMARY KEY AUTO_INCREMENT");
        columns.put("name", "VARCHAR(100)");

        System.out.println("Creating table...");
        mySQL.createTable("testTable", columns);
        System.out.println("Table created. Now deleting...");

    }

    @Test
    public void testDeleteTable() throws SQLException, ClassNotFoundException {
        mySQL.deleteTable("testTable");
        System.out.println("Table deleted.");
    }


    @Test
    public void testUseDatabase() {
        mySQL.useDatabase("testDB");
        assertEquals("testDB", mySQL.getDatabase());
    }

    @Test
    public void testUseDatabaseByName() throws SQLException {
        mySQL.createDatabase("anotherTestDB");
        mySQL.useDatabase("anotherTestDB");
        assertEquals("anotherTestDB", mySQL.getDatabase());
        mySQL.deleteDatabase("anotherTestDB");
    }
}
