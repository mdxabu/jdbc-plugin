package com.jdbcplugin.utils.sql;

public interface ConnectionMananger {

    public void setCredentials(String username, String password);

    public void connect(String URL);

    public void disconnect();

    public boolean isConnected();

    public void createDatabase(String databaseName);

    public void useDatabase(String databaseName);

    public void createTable(String tableName);

    public void dropTable(String tableName);

    public void deleteDatabase(String databaseName);

    public void insertOne();

    public void insertMany();

}
