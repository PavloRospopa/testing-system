package com.gmail.at.rospopa.pavlo.testingsystem.service;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.User;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.ConnectionManager;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.UserDao;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.impl.JdbcUserDao;

import java.sql.Connection;
import java.util.List;

public class Service {

    public List<User> findAllUsers(){
        ConnectionManager mgr = new ConnectionManager();
        Connection connection = mgr.getConnection();
        UserDao userDao = new JdbcUserDao(connection);
        return userDao.findAll();
    }
}
