package com.gmail.at.rospopa.pavlo.testingsystem.service.impl;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.Subject;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.SubjectDao;
import com.gmail.at.rospopa.pavlo.testingsystem.service.SubjectService;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {

    private SubjectDao subjectDao;

    public SubjectServiceImpl(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    @Override
    public List<Subject> findAll() {
        return null;
    }

    @Override
    public Subject findById(Long id) {
        return null;
    }

    @Override
    public Long add(Subject entity) {
        return null;
    }

    @Override
    public boolean update(Subject entity) {
        return false;
    }
}
