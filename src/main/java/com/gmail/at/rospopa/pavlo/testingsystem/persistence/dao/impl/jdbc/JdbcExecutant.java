package com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.impl.jdbc;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.Entity;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.ConnectionManager;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.impl.jdbc.mappers.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcExecutant<T extends Entity> {
    private static final Logger LOGGER = LogManager.getLogger();
    private ConnectionManager manager;
    private Mapper<T> mapper;

    public JdbcExecutant(ConnectionManager manager, Mapper<T> mapper) {
        this.manager = manager;
        this.mapper = mapper;
    }

    public List<T> executeQuery(String query, Object... params){
        List<T> entities = new ArrayList<>();
        Connection connection = manager.getConnection();
        if (connection == null) {
            entities.add(null);
            return entities;
        }
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            setParams(stmt, params);
            ResultSet rs  = stmt.executeQuery();
            while(rs.next()){
                entities.add(mapper.map(rs));
            }
        }
        catch (SQLException e){
            LOGGER.warn("SQL exception during executing query to database", e);
        }
        finally {
            manager.close(connection);
        }
        if (entities.isEmpty()){
            entities.add(null);
        }
        return entities;
    }

    public int executeUpdate(String updateQuery, Object... params) {
        int updatedRows = 0;
        Connection connection = manager.getConnection();
        if (connection == null) {
            return updatedRows;
        }
        try (PreparedStatement stmt = connection.prepareStatement(updateQuery)) {
            setParams(stmt, params);
            updatedRows = stmt.executeUpdate();
        }
        catch (SQLException e){
            LOGGER.warn("SQL exception during processing update query to database", e);
        }
        finally {
            manager.close(connection);
        }
        return updatedRows;
    }

    public Long executeInsert(String insertQuery, Object... params) {
        Connection connection = manager.getConnection();
        if (connection == null) {
            return null;
        }
        try (PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            setParams(stmt, params);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getLong(1);
            }
        }
        catch (SQLException e){
            LOGGER.warn("SQL exception during inserting data to database", e);
        }
        finally {
            manager.close(connection);
        }
        return null;
    }

    public Long findRoleId(String query, String role){
        Long id = null;
        Connection connection = manager.getConnection();
        if (connection == null){
            return null;
        }
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            setParams(stmt, role);
            ResultSet rs  = stmt.executeQuery();
            if(rs.next()){
                id = rs.getLong("id");
            }
        }
        catch (SQLException e){
            LOGGER.warn("SQL exception during finding id for given role", e);
        }
        finally {
            manager.close(connection);
        }
        return id;
    }

    private void setParams(PreparedStatement stmt, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++){
            stmt.setObject(i + 1, params[i]);
        }
    }
}
