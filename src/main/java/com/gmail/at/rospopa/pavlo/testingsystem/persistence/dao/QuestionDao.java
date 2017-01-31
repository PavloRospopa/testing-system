package com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.Question;
import com.gmail.at.rospopa.pavlo.testingsystem.entities.Test;

import java.util.List;

public interface QuestionDao extends Dao<Long, Question>{

    List<Question> findQuestionsByTest(Long id);
}
