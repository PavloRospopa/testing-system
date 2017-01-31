package com.gmail.at.rospopa.pavlo.testingsystem.service.impl;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.Test;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.TestDao;
import com.gmail.at.rospopa.pavlo.testingsystem.service.TestService;

import java.util.List;

public class TestServiceImpl implements TestService {

    private TestDao testDao;

    public TestServiceImpl(TestDao testDao) {
        this.testDao = testDao;
    }

    @Override
    public List<Test> findAll() {
        return null;
    }

    @Override
    public Test findById(Long id) {
        return null;
    }

    @Override
    public Long add(Test entity) {
        return null;
    }

    @Override
    public boolean update(Test entity) {
        return false;
    }

    @Override
    public List<Test> findTestsBySubject(Long id) {
        return null;
    }
}
