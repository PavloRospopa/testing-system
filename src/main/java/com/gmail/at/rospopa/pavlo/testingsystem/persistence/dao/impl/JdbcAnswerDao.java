package com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.impl;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.Answer;
import com.gmail.at.rospopa.pavlo.testingsystem.entities.Question;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.AnswerDao;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.impl.jdbc.JdbcExecutant;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.impl.jdbc.mappers.AnswerMapper;

import java.sql.Connection;
import java.util.List;

public class JdbcAnswerDao implements AnswerDao {

    private static final String FIND_ALL_SQL = "SELECT * FROM answers";
    private static final String FIND_BY_ID_SQL = "SELECT * FROM answers WHERE id=?";
    private static final String DELETE_SQL = "DELETE FROM answers WHERE id=?";
    private static final String UPDATE_SQL = "UPDATE answers SET answer_text=?, is_right=?, question_id=? WHERE id=?";
    private static final String INSERT_SQL = "INSERT INTO answers (answer_text, is_right, question_id) VALUES (?, ?, ?)";
    private static final String FIND_BY_QUESTION_SQL = "SELECT * FROM answers WHERE question_id=?";
    private static final String FIND_SOME_ANS_IN_QUESTION_SQL ="SELECT * FROM answers WHERE question_id=? AND " +
            "is_right=?";

    private JdbcExecutant<Answer> jdbcExecutant;

    public JdbcAnswerDao(Connection connection) {
        jdbcExecutant = new JdbcExecutant<>(connection, new AnswerMapper());
    }

    @Override
    public List<Answer> findAll() {
        return jdbcExecutant.executeQuery(FIND_ALL_SQL);
    }

    @Override
    public Answer findById(Long id) {
        return jdbcExecutant.executeQuery(FIND_BY_ID_SQL, id).get(0);
    }

    @Override
    public int delete(Answer entity) {
        return jdbcExecutant.executeUpdate(DELETE_SQL, entity.getId());
    }

    @Override
    public int delete(Long id) {
        return jdbcExecutant.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public int update(Answer entity) {
        return jdbcExecutant.executeUpdate(UPDATE_SQL, entity.getAnswerText(), entity.isRight(),
                entity.getQuestion().getId(), entity.getId());
    }

    @Override
    public Long add(Answer entity) {
        return jdbcExecutant.executeInsert(INSERT_SQL, entity.getAnswerText(), entity.isRight(),
                entity.getQuestion().getId());
    }

    @Override
    public List<Answer> findAnswersByQuestion(Question question) {
        return jdbcExecutant.executeQuery(FIND_BY_QUESTION_SQL, question.getId());
    }

    @Override
    public List<Answer> findRightAnswersByQuestion(Question question) {
        return jdbcExecutant.executeQuery(FIND_SOME_ANS_IN_QUESTION_SQL, question.getId(), true);
    }
}
