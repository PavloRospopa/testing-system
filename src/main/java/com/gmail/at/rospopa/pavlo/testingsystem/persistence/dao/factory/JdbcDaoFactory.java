package com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.factory;

import com.gmail.at.rospopa.pavlo.testingsystem.persistence.ConnectionManager;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.*;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.impl.*;

public class JdbcDaoFactory implements DaoFactory {

    private ConnectionManager manager;

    public JdbcDaoFactory(ConnectionManager manager) {
        this.manager = manager;
    }

    @Override
    public UserDao getUserDao() {
        return new JdbcUserDao(manager);
    }

    @Override
    public SubjectDao getSubjectDao() {
        return new JdbcSubjectDao(manager);
    }

    @Override
    public TestDao getTestDao() {
        return new JdbcTestDao(manager);
    }

    @Override
    public QuestionDao getQuestionDao() {
        return new JdbcQuestionDao(manager);
    }

    @Override
    public AnswerDao getAnswerDao() {
        return new JdbcAnswerDao(manager);
    }
}
