package com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.factory;

import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.*;

public interface DaoFactory {
    UserDao getUserDao();
    SubjectDao getSubjectDao();
    TestDao getTestDao();
    QuestionDao getQuestionDao();
    AnswerDao getAnswerDao();
}
