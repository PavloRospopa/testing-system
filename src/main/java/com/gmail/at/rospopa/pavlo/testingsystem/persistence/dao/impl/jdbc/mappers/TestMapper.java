package com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.impl.jdbc.mappers;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.Subject;
import com.gmail.at.rospopa.pavlo.testingsystem.entities.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestMapper implements Mapper<Test> {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Test map(ResultSet rs) {
        Test test = new Test();
        try{
            test.setId(rs.getLong("id"));
            test.setName(rs.getString("name"));
            test.setSubject(new Subject(rs.getLong("subject_id")));
        }
        catch (SQLException e){
            LOGGER.error("SQL exception during processing result set", e);
        }
        return test;
    }
}
