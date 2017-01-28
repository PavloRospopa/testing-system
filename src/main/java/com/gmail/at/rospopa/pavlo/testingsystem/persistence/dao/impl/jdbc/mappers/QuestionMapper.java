package com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.impl.jdbc.mappers;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.Question;
import com.gmail.at.rospopa.pavlo.testingsystem.entities.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionMapper implements Mapper<Question> {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Question map(ResultSet rs) {
        Question question = new Question();
        try{
            question.setId(rs.getLong("id"));
            question.setDesc(rs.getString("desc"));
            question.setTest(new Test(rs.getLong("test_id")));
        }
        catch (SQLException e){
            LOGGER.error("SQL exception during processing result set", e);
        }
        return question;
    }
}
