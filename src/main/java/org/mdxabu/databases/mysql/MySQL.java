package org.mdxabu.databases.mysql;

import org.mdxabu.databases.run.run;

import java.sql.*;
import java.util.Map;
import java.util.logging.Logger;

public class MySQL {

    String USERNAME;

    String PASSWORD;
    String ENDPOINT;
    String PORT;
    String Database;

    String BASEENDPOINT = "jdbc:mysql://";

    Statement MySQLStatement;

    Connection MySQLConnection;



//    Statement

    public void setCredentials(String USERNAME,String PASSWORD) {
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
    }

    public void setENDPOINT(String ENDPOINT) {
        this.ENDPOINT = ENDPOINT;
        BASEENDPOINT+=this.ENDPOINT;
    }

    public void setPORT(String PORT) {
        this.PORT = PORT;
        BASEENDPOINT+= ":"+this.PORT;
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

    public String getDatabase(){return this.Database;}

    @Override
    public String toString() {
        return "\t\tMySQL Credentials" +
                "\n=========================="+
                "\nUSERNAME='" + USERNAME + '\'' +
                "\nPASSWORD='" + PASSWORD + '\'' +
                "\nENDPOINT='" + ENDPOINT + '\'' +
                "\nPORT='" + PORT + '\'' +
                "\nBASEENDPOINT='" + BASEENDPOINT + '\'' +
                '}';
    }

    public void start() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.MySQLConnection = DriverManager.getConnection(this.BASEENDPOINT);
        this.MySQLStatement = this.MySQLConnection.createStatement();
        run asciitext = new run();
    }

    public void createDatabase(String DatabaseName) throws SQLException {
        this.Database = DatabaseName;
        String query = "CREATE DATABASE IF NOT EXISTS "+DatabaseName+";";
        this.MySQLStatement.executeUpdate(query);
        System.out.println(DatabaseName+" Was Created Successfully :)");
    }

    public void useDatabase(){

        if(this.Database != null) {
            String query = "USE "+this.Database+";";
            try {
                this.MySQLStatement.executeUpdate(query);
                System.out.println(this.Database + " Was Used Successfully!");
            } catch (Exception e) {
                System.err.println("Something error on using database, Check whether database is present or not.");
            }
        }
    }

    public void useDatabase(String DatabaseName){
        if(this.Database==null){
            this.Database = DatabaseName;
            String query = "USE "+DatabaseName+";";
            try {
                this.MySQLStatement.executeUpdate(query);
                System.out.println(this.Database + " Was Used Successfully!");
            } catch (Exception e) {
                System.err.println("Something error on using database, Check whether database is present or not.");
            }
        }
    }

    public void createTable(String tableName, Map<String, String> columns)  {
        try {
            StringBuilder query = new StringBuilder("CREATE TABLE " + tableName + " (");

            for (Map.Entry<String, String> column : columns.entrySet()) {
                query.append(column.getKey()).append(" ").append(column.getValue()).append(", ");
            }

            query.setLength(query.length() - 2);

            query.append(");");

            this.MySQLStatement.executeUpdate(query.toString());
            System.out.println(tableName + " Was Created Successfully!");
        }
        catch(Exception e){
            System.err.println("The table **"+tableName+"** could not be created or already exists.");
        }


    }

    public void deleteTable(String tableName) throws SQLException {
        if(tableName!=null) {
            String query = "DROP TABLE " + tableName;
            this.MySQLStatement.executeUpdate(query);
            System.out.println(tableName + " Was Deleted Successfully!");
        }
        else{
            System.err.println("The Table name not be a null value.");
        }

    }

    public void printTable(String TableName) throws SQLException {
        String query = "SELECT * FROM " + TableName;
        ResultSet tableRs = this.MySQLStatement.executeQuery(query);
        while (tableRs.next()){

        }
    }


}
