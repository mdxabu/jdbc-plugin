package org.mdxabu.Databases;

import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        MySQL db = new MySQL("localhost","3306");

        Statement st = db.getConnection();
    }
}
