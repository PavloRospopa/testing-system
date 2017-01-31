package com.gmail.at.rospopa.pavlo.testingsystem.service;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.Subject;
import com.gmail.at.rospopa.pavlo.testingsystem.entities.Test;

import java.util.List;

public interface TestService extends Service<Long, Test> {
    List<Test> findTestsBySubject(Long id);
}
