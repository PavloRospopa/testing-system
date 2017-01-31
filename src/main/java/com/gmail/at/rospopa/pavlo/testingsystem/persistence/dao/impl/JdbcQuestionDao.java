package com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.impl;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.Question;
import com.gmail.at.rospopa.pavlo.testingsystem.entities.Test;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.ConnectionManager;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.QuestionDao;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.impl.jdbc.JdbcExecutant;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.impl.jdbc.mappers.QuestionMapper;

import java.sql.Connection;
import java.util.List;

public class JdbcQuestionDao implements QuestionDao {

    private static final String FIND_ALL_SQL = "SELECT * FROM questions";
    private static final String FIND_BY_ID_SQL = "SELECT * FROM questions WHERE id=?";
    private static final String DELETE_SQL = "DELETE FROM questions WHERE id=?";
    private static final String UPDATE_SQL = "UPDATE questions SET desc=?, test_id=? WHERE id=?";
    private static final String INSERT_SQL = "INSERT INTO questions (desc, test_id) VALUES (?, ?)";
    private static final String FIND_BY_TEST_SQL = "SELECT * FROM questions WHERE test_id=?";

    private JdbcExecutant<Question> jdbcExecutant;

    public JdbcQuestionDao(ConnectionManager manager) {
        jdbcExecutant = new JdbcExecutant<>(manager, new QuestionMapper());
    }

    @Override
    public List<Question> findAll() {
        return jdbcExecutant.executeQuery(FIND_ALL_SQL);
    }

    @Override
    public Question findById(Long id) {
        return jdbcExecutant.executeQuery(FIND_BY_ID_SQL, id).get(0);
    }

    @Override
    public int delete(Question entity) {
        return jdbcExecutant.executeUpdate(DELETE_SQL, entity.getId());
    }

    @Override
    public int delete(Long id) {
        return jdbcExecutant.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public int update(Question entity) {
        return jdbcExecutant.executeUpdate(UPDATE_SQL, entity.getDesc(), entity.getTest().getId(), entity.getId());
    }

    @Override
    public Long add(Question entity) {
        return jdbcExecutant.executeInsert(INSERT_SQL, entity.getDesc(), entity.getTest().getId());
    }

    @Override
    public List<Question> findQuestionsByTest(Long id) {
        return jdbcExecutant.executeQuery(FIND_BY_TEST_SQL, id);
    }
}
