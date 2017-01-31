package com.gmail.at.rospopa.pavlo.testingsystem.service;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.Entity;

import java.util.List;

public interface Service<PK, T extends Entity> {
    List<T> findAll();
    T findById(PK id);
    PK add(T entity);
    boolean update(T entity);
}
