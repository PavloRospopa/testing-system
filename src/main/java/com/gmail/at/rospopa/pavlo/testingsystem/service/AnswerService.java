package com.gmail.at.rospopa.pavlo.testingsystem.service;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.Answer;

import java.util.List;

public interface AnswerService extends Service<Long, Answer> {
    List<Answer> findAnswersByQuestion(Long id);
    List<Answer> findRightAnswersByQuestion(Long id);
}
