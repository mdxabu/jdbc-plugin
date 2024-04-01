package org.mdxabu.Databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {

    String endpoint;

    String port;
    String URL;

    public MySQL(String DBendpoint,String DBport) {
        this.endpoint = DBendpoint;
        this.port = DBport;
        this.URL = "jdbc:mysql://"+endpoint+":"+port+"/";
    }


    public Statement getConnection(String user,String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Statement statement;
        Connection connection = DriverManager.getConnection(URL, user, password);
        statement = connection.createStatement();
        return statement;
    }
}
