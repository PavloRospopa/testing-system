package com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.impl.jdbc.mappers;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.Entity;

import java.sql.ResultSet;

public interface Mapper<T extends Entity> {
    T map(ResultSet rs);
}
