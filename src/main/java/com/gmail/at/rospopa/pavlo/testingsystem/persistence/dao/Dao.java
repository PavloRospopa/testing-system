package com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.Entity;

import java.util.List;

public interface Dao<PK, T extends Entity> {

    List<T> findAll();
    T findById(PK id);
    int delete(T entity);
    int delete(PK id);
    int update(T entity);
    Long add(T entity);
}
