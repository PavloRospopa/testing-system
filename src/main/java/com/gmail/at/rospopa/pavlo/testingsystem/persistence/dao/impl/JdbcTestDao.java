package com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.impl;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.Subject;
import com.gmail.at.rospopa.pavlo.testingsystem.entities.Test;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.TestDao;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.impl.jdbc.JdbcExecutant;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.impl.jdbc.mappers.TestMapper;

import java.sql.Connection;
import java.util.List;

public class JdbcTestDao implements TestDao{

    private static final String FIND_ALL_SQL = "SELECT * FROM tests";
    private static final String FIND_BY_ID_SQL = "SELECT * FROM tests WHERE id=?";
    private static final String DELETE_SQL = "DELETE FROM tests WHERE id=?";
    private static final String UPDATE_SQL = "UPDATE tests SET name=?, subject_id=? WHERE id=?";
    private static final String INSERT_SQL = "INSERT INTO tests (name, subject_id) VALUES (?, ?)";
    private static final String FIND_BY_SUBJECT_SQL = "SELECT * FROM tests WHERE subject_id=?";

    private JdbcExecutant<Test> jdbcExecutant;

    public JdbcTestDao(Connection connection) {
        jdbcExecutant = new JdbcExecutant<>(connection, new TestMapper());
    }

    @Override
    public List<Test> findAll() {
        return jdbcExecutant.executeQuery(FIND_ALL_SQL);
    }

    @Override
    public Test findById(Long id) {
        return jdbcExecutant.executeQuery(FIND_BY_ID_SQL, id).get(0);
    }

    @Override
    public int delete(Test entity) {
        return jdbcExecutant.executeUpdate(DELETE_SQL, entity.getId());
    }

    @Override
    public int delete(Long id) {
        return jdbcExecutant.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public int update(Test entity) {
        return jdbcExecutant.executeUpdate(UPDATE_SQL, entity.getName(), entity.getSubject().getId(), entity.getId());
    }

    @Override
    public Long add(Test entity) {
        return jdbcExecutant.executeInsert(INSERT_SQL, entity.getName(), entity.getSubject().getId());
    }

    @Override
    public List<Test> findTestsBySubject(Subject subject) {
        return jdbcExecutant.executeQuery(FIND_BY_SUBJECT_SQL, subject.getId());
    }
}
