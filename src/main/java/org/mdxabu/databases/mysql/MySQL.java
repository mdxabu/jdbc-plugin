package org.mdxabu.databases.mysql;

import org.mdxabu.databases.run.run;

import java.sql.*;
import java.util.Map;

public class MySQL {

    private String USERNAME;
    private String PASSWORD;
    private String ENDPOINT;
    private String PORT;
    private String Database;

    private String BASEENDPOINT = "jdbc:mysql://";

    private Statement MySQLStatement;

    public MySQL() {
        run asciitext = new run();
    }

    public void setCredentials(String USERNAME, String PASSWORD) {
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
    }

    public void setENDPOINT(String ENDPOINT) {
        this.ENDPOINT = ENDPOINT;
    }

    public void setPORT(String PORT) {
        this.PORT = PORT;
    }

    public String getUSERNAME() {
        return this.USERNAME;
    }

    public String getPASSWORD() {
        return this.PASSWORD;
    }

    public String getENDPOINT() {
        return this.ENDPOINT;
    }

    public String getPORT() {
        return this.PORT;
    }

    public String getBASEENDPOINT() {
        return this.BASEENDPOINT;
    }

    public String getDatabase() {
        return this.Database;
    }

    @Override
    public String toString() {
        return "\t\tMySQL Credentials" +
                "\n==========================" +
                "\nUSERNAME='" + USERNAME + '\'' +
                "\nPASSWORD='" + PASSWORD + '\'' +
                "\nENDPOINT='" + ENDPOINT + '\'' +
                "\nPORT='" + PORT + '\'' +
                "\nBASEENDPOINT='" + BASEENDPOINT + ENDPOINT + ":" + PORT + "/'" +
                '}';
    }

    public void start() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String fullEndpoint = BASEENDPOINT + ENDPOINT + ":" + PORT;
        Connection mySQLConnection = DriverManager.getConnection(fullEndpoint, USERNAME, PASSWORD);
        this.MySQLStatement = mySQLConnection.createStatement();
    }

    public void createDatabase(String DatabaseName) throws SQLException {
        this.Database = DatabaseName;
        String query = "CREATE DATABASE IF NOT EXISTS " + DatabaseName + ";";
        this.MySQLStatement.executeUpdate(query);
        System.out.println(DatabaseName + " Was Created Successfully :)");
    }

    public void deleteDatabase(String DatabaseName) throws SQLException {
        this.Database = null;
        String query = "DROP DATABASE " + DatabaseName;
        this.MySQLStatement.executeUpdate(query);
        System.out.println(DatabaseName + " Was Successfully Deleted");
    }

    public void useDatabase() {
        if (this.Database != null) {
            String query = "USE " + this.Database + ";";
            try {
                this.MySQLStatement.executeUpdate(query);
                System.out.println(this.Database + " Was Used Successfully!");
            } catch (Exception e) {
                System.err.println("Something error on using database, Check whether database is present or not.");
            }
        }
    }

    public void useDatabase(String DatabaseName) {
        if (this.Database == null) {
            this.Database = DatabaseName;
            String query = "USE " + DatabaseName + ";";
            try {
                this.MySQLStatement.executeUpdate(query);
                System.out.println(this.Database + " Was Used Successfully!");
            } catch (Exception e) {
                System.err.println("Something error on using database, Check whether database is present or not.");
            }
        }
    }

    public void showAllTables() {
        try {
            String query = "SHOW TABLES;";
            ResultSet resultSet = this.MySQLStatement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        } catch (Exception e) {
            System.err.println("Check the database is available or not!");
        }
    }

    public void createTable(String tableName, Map<String, String> columns) {
        try {
            StringBuilder query = new StringBuilder("CREATE TABLE " + tableName + " (");

            for (Map.Entry<String, String> column : columns.entrySet()) {
                query.append(column.getKey()).append(" ").append(column.getValue()).append(", ");
            }

            query.setLength(query.length() - 2);

            query.append(");");

            this.MySQLStatement.executeUpdate(query.toString());
            System.out.println(tableName + " Was Created Successfully!");
        } catch (Exception e) {
            System.err.println("The table **" + tableName + "** could not be created or already exists.");
        }
    }

    public void deleteTable(String tableName) {
        if (tableName != null) {
            String query = "DROP TABLE " + tableName + ";";
            try {
                this.MySQLStatement.executeUpdate(query);
                System.out.println(tableName + " Was Deleted Successfully!");
            } catch (SQLException e) {
                System.err.println("Failed to delete table " + tableName + ". Error: " + e.getMessage());
            }
        } else {
            System.err.println("The table name must not be null or empty.");
        }
    }

}
