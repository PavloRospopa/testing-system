package com.gmail.at.rospopa.pavlo.testingsystem.service.impl;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.Answer;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.AnswerDao;
import com.gmail.at.rospopa.pavlo.testingsystem.service.AnswerService;

import java.util.List;

public class AnswerServiceImpl implements AnswerService {

    private AnswerDao answerDao;

    public AnswerServiceImpl(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    @Override
    public List<Answer> findAll() {
        return null;
    }

    @Override
    public Answer findById(Long id) {
        return null;
    }

    @Override
    public Long add(Answer entity) {
        return null;
    }

    @Override
    public boolean update(Answer entity) {
        return false;
    }

    @Override
    public List<Answer> findAnswersByQuestion(Long id) {
        return null;
    }

    @Override
    public List<Answer> findRightAnswersByQuestion(Long id) {
        return null;
    }
}
