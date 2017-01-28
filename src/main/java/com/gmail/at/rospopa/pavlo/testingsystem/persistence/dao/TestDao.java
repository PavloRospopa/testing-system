package com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.Subject;
import com.gmail.at.rospopa.pavlo.testingsystem.entities.Test;

import java.util.List;

public interface TestDao extends Dao<Long, Test> {

    List<Test> findTestsBySubject(Subject subject);
}
