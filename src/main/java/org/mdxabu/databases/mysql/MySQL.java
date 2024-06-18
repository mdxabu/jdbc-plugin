package org.mdxabu.databases.mysql;

import org.mdxabu.databases.run.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

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
        run asciitext = new run();
    }

    public void createDatabase(String DatabaseName) throws SQLException {
        this.Database = DatabaseName;
        String query = "CREATE DATABASE IF NOT EXISTS "+DatabaseName+";";
        this.MySQLStatement.executeUpdate(query);
        System.out.println(DatabaseName+" Was Created Successfully :)");
    }

    public void useDatabase(){
        String query = "USE "+this.Database+";";
        try {
            this.MySQLStatement.executeUpdate(query);
        System.out.println(this.Database+" Was Used Successfully!");
        }
        catch (Exception e){
            System.err.println("Something error on using database, Check whether database is present or not.");
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
        catch (Exception e){
            System.err.println("This table already created!");
        }
    }

    public void deleteTable(String Table) throws SQLException {
        String query = "DROP TABLE "+Table;
        this.MySQLStatement.executeUpdate(query);
    }


}
