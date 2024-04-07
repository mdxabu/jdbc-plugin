package org.mdxabu.databases;

import java.sql.Statement;

public class MySQL {

    String USERNAME;

    String PASSWORD;
    String ENDPOINT;
    String PORT;

    String BASEENDPOINT = "jdbc:mysql://";

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
        return "MySQL{" +
                "USERNAME='" + USERNAME + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", ENDPOINT='" + ENDPOINT + '\'' +
                ", PORT='" + PORT + '\'' +
                ", BASEENDPOINT='" + BASEENDPOINT + '\'' +
                '}';
    }
}
