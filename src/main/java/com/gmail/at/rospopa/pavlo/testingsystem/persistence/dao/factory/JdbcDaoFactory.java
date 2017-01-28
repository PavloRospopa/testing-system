package com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.factory;

import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.*;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.impl.*;

import java.sql.Connection;

public class JdbcDaoFactory implements DaoFactory {

    private Connection connection;

    public JdbcDaoFactory(Connection connection) {
        this.connection = connection;
    }

    @Override
    public UserDao getUserDao() {
        return new JdbcUserDao(connection);
    }

    @Override
    public SubjectDao getSubjectDao() {
        return new JdbcSubjectDao(connection);
    }

    @Override
    public TestDao getTestDao() {
        return new JdbcTestDao(connection);
    }

    @Override
    public QuestionDao getQuestionDao() {
        return new JdbcQuestionDao(connection);
    }

    @Override
    public AnswerDao getAnswerDao() {
        return new JdbcAnswerDao(connection);
    }
}
