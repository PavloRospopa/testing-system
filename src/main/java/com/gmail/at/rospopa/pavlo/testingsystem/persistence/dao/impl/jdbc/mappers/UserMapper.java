package com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.impl.jdbc.mappers;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.Role;
import com.gmail.at.rospopa.pavlo.testingsystem.entities.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements Mapper<User> {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public User map(ResultSet rs) {
        User user = new User();
        try {
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setSurname(rs.getString("surname"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setRole(Role.valueOf(rs.getString("role").toUpperCase()));
        }
        catch (SQLException e){
            LOGGER.error("SQL exception during processing result set", e);
        }
        return user;
    }
}
