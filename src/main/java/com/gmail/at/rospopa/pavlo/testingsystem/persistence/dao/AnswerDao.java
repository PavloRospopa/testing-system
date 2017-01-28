package com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.Answer;
import com.gmail.at.rospopa.pavlo.testingsystem.entities.Question;

import java.util.List;

public interface AnswerDao extends Dao<Long, Answer> {

    List<Answer> findAnswersByQuestion(Question question);
    List<Answer> findRightAnswersByQuestion(Question question);
}
