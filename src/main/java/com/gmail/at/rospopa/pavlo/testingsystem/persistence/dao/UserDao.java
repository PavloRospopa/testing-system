package com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.Role;
import com.gmail.at.rospopa.pavlo.testingsystem.entities.User;

import java.sql.Connection;
import java.util.List;

public interface UserDao extends Dao<Long, User> {

    List<User> findAllStudents();
    User findByUsernamePassword(String username, String password);
    Long findRoleId(Role role);
}
