package org.mdxabu;

import org.mdxabu.databases.MySQL;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        MySQL mydb = new MySQL();

        mydb.setCredentials("root","password");
        mydb.setENDPOINT("localhost");
        mydb.setPORT("3306");
        mydb.start();
        mydb.CreateDatabase("testdbforjdbcplugin");

//        System.out.println(mydb.toString());

    }
}
