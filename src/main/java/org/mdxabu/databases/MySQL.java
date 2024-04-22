package org.mdxabu.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {

    String USERNAME;

    String PASSWORD;
    String ENDPOINT;
    String PORT;


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
        return USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getENDPOINT() {
        return ENDPOINT;
    }

    public String getPORT() {
        return PORT;
    }

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
    }


}
