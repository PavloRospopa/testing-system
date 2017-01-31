package com.gmail.at.rospopa.pavlo.testingsystem.service.impl;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.Question;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.QuestionDao;
import com.gmail.at.rospopa.pavlo.testingsystem.service.QuestionService;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    private QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public List<Question> findAll() {
        return null;
    }

    @Override
    public Question findById(Long id) {
        return null;
    }

    @Override
    public Long add(Question entity) {
        return null;
    }

    @Override
    public boolean update(Question entity) {
        return false;
    }

    @Override
    public List<Question> findQuestionsByTest(Long id) {
        return null;
    }
}
