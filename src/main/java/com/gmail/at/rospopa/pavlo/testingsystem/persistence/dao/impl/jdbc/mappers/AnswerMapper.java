package com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.impl.jdbc.mappers;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.Answer;
import com.gmail.at.rospopa.pavlo.testingsystem.entities.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnswerMapper implements Mapper<Answer> {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Answer map(ResultSet rs) {
        Answer answer = new Answer();
        try{
            answer.setId(rs.getLong("id"));
            answer.setAnswerText(rs.getString("answer_text"));
            answer.setRight(rs.getBoolean("is_right"));
            answer.setQuestion(new Question(rs.getLong("question_id")));
        }
        catch (SQLException e){
            LOGGER.error("SQL exception during processing result set", e);
        }
        return answer;
    }
}
