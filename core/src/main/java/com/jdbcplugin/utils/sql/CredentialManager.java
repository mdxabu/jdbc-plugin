package com.jdbcplugin.utils.sql;

public interface CredentialManager {

    public void setUsername(String username);

    public void setPassword(String password);

    public String getUsername();

    public String gethashedPassword();
}
