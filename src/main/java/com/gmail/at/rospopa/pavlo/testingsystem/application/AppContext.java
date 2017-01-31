package com.gmail.at.rospopa.pavlo.testingsystem.application;

import com.gmail.at.rospopa.pavlo.testingsystem.persistence.ConnectionManager;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.factory.DaoFactory;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.factory.JdbcDaoFactory;
import com.gmail.at.rospopa.pavlo.testingsystem.service.*;
import com.gmail.at.rospopa.pavlo.testingsystem.service.impl.*;

public enum AppContext {
    INSTANCE;

    private ConnectionManager manager;
    private DaoFactory daoFactory;
    private ServiceHolder serviceHolder;

    AppContext() {
        serviceHolder = ServiceHolder.INSTANCE;
        manager = ConnectionManager.getInstance();
    }

    public ConnectionManager getManager() {
        return manager;
    }

    public DaoFactory getDaoFactory() {
        return daoFactory;
    }

    public ServiceHolder getServiceHolder() {
        return serviceHolder;
    }

    void init(){
        daoFactory = new JdbcDaoFactory(manager);

        UserService userService = new UserServiceImpl(daoFactory.getUserDao());
        TestService testService = new TestServiceImpl(daoFactory.getTestDao());
        SubjectService subjectService = new SubjectServiceImpl(daoFactory.getSubjectDao());
        QuestionService questionService = new QuestionServiceImpl(daoFactory.getQuestionDao());
        AnswerService answerService = new AnswerServiceImpl(daoFactory.getAnswerDao());

        serviceHolder.put(UserService.class, userService);
        serviceHolder.put(TestService.class, testService);
        serviceHolder.put(SubjectService.class, subjectService);
        serviceHolder.put(QuestionService.class, questionService);
        serviceHolder.put(AnswerService.class, answerService);
    }
}
