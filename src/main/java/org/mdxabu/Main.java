package org.mdxabu;

import org.mdxabu.databases.MySQL;

public class Main {

    public static void main(String[] args) {

        MySQL mydb = new MySQL();

        mydb.setCredentials("root","password");
        mydb.setENDPOINT("localhost");
        mydb.setPORT("3306");


    }
}
