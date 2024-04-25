package org.mdxabu.databases.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AWSMySQL {
    String USERNAME;

    String PASSWORD;
    String ENDPOINT;
    String PORT;


    String BASEENDPOINT = "jdbc:mysql:aws://";

    Statement MySQLStatement;

    Connection MySQLConnection;



    // Set Credentials like: Username & Password of the AWS database
    public void setCredentials(String USERNAME,String PASSWORD) {
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
    }

    // Set Endpoint of the AWS database
    public void setENDPOINT(String ENDPOINT) {
        this.ENDPOINT = ENDPOINT;
        BASEENDPOINT+=this.ENDPOINT;
    }

    // Set Port of the AWS database
    public void setPORT(String PORT) {
        this.PORT = PORT;
        BASEENDPOINT+= ":"+this.PORT;
    }

    // Get Username for the AWS database
    public String getUSERNAME() {
        return USERNAME;
    }

    // Get Password for the AWS database
    public String getPASSWORD() {
        return PASSWORD;
    }

    // Get Endpoint of the AWS database
    public String getENDPOINT() {
        return ENDPOINT;
    }

    // Get Port of the AWS database
    public String getPORT() {
        return PORT;
    }

    // Get BaseEndpoint of the AWS database
    public String getBASEENDPOINT() {
        return BASEENDPOINT;
    }

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
    }

    public void CreateDatabase(String DatabaseName) throws SQLException {
        String query = "CREATE DATABASE IF NOT EXISTS "+DatabaseName+";";
        this.MySQLStatement.executeUpdate(query);
        System.out.println(DatabaseName+" Was Created Successfully :)");
    }

    public void UseDatabase(String DatabaseName) throws SQLException {
        String query = "USE "+DatabaseName+";";
        this.MySQLStatement.executeUpdate(query);
        System.out.println(DatabaseName+" Was Used Successfully!");
    }

    public void CreateTable(String Query) throws SQLException {
        this.MySQLStatement.executeUpdate(Query);
    }
}
