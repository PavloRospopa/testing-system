package com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.impl.jdbc.mappers;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectMapper implements Mapper<Subject> {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Subject map(ResultSet rs) {
        Subject subject = new Subject();
        try{
            subject.setId(rs.getLong("id"));
            subject.setName(rs.getString("name"));
        }
        catch (SQLException e){
            LOGGER.error("SQL exception during processing result set", e);
        }
        return subject;
    }
}
