package com.gmail.at.rospopa.pavlo.testingsystem.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final ConnectionManager INSTANCE = new ConnectionManager();
    private DataSource dataSource;

    private ConnectionManager() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/testing_system");
        }
        catch (NamingException e){
            LOGGER.error("Cannot obtain JNDI DataSource object", e);
        }
    }

    public static ConnectionManager getInstance(){
        return INSTANCE;
    }

    public Connection getConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        }
        catch (SQLException e){
            LOGGER.error("Cannot obtain connection to the database", e);
        }
        return connection;
    }

    public void close(Connection connection){
        try {
            if(connection != null) {
                connection.close();
            }
        }
        catch (SQLException e){
            LOGGER.error("Cannot close connection to the database", e);
        }
    }
}
