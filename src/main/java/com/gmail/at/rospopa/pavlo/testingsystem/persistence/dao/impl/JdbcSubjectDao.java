package com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.impl;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.Subject;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.SubjectDao;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.impl.jdbc.JdbcExecutant;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.impl.jdbc.mappers.SubjectMapper;

import java.sql.Connection;
import java.util.List;

public class JdbcSubjectDao implements SubjectDao {

    private static final String FIND_ALL_SQL = "SELECT * FROM subjects";
    private static final String FIND_BY_ID_SQL = "SELECT * FROM subjects WHERE id=?";
    private static final String DELETE_SQL = "DELETE FROM subjects WHERE id=?";
    private static final String UPDATE_SQL = "UPDATE subjects SET name=? WHERE id=?";
    private static final String INSERT_SQL = "INSERT INTO subjects (name) VALUES (?)";

    private JdbcExecutant<Subject> jdbcExecutant;

    public JdbcSubjectDao(Connection connection) {
        jdbcExecutant = new JdbcExecutant<>(connection, new SubjectMapper());
    }

    @Override
    public List<Subject> findAll() {
        return jdbcExecutant.executeQuery(FIND_ALL_SQL);
    }

    @Override
    public Subject findById(Long id) {
        return jdbcExecutant.executeQuery(FIND_BY_ID_SQL, id).get(0);
    }

    @Override
    public int delete(Subject entity) {
        return jdbcExecutant.executeUpdate(DELETE_SQL, entity.getId());
    }

    @Override
    public int delete(Long id) {
        return jdbcExecutant.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public int update(Subject entity) {
        return jdbcExecutant.executeUpdate(UPDATE_SQL, entity.getName(), entity.getId());
    }

    @Override
    public Long add(Subject entity) {
        return jdbcExecutant.executeInsert(INSERT_SQL, entity.getName());
    }
}
