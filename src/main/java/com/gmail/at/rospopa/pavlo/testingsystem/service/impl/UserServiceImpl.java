package com.gmail.at.rospopa.pavlo.testingsystem.service.impl;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.User;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.UserDao;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.factory.DaoFactory;
import com.gmail.at.rospopa.pavlo.testingsystem.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public Long add(User entity) {
        return null;
    }

    @Override
    public boolean update(User entity) {
        return false;
    }
}
