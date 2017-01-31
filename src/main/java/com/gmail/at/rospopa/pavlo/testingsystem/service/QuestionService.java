package com.gmail.at.rospopa.pavlo.testingsystem.service;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.Question;

import java.util.List;

public interface QuestionService extends Service<Long, Question> {
    List<Question> findQuestionsByTest(Long id);
}
