package com.gmail.at.rospopa.pavlo.testingsystem.service;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.User;

public interface UserService extends Service<Long, User>{
    boolean login(String username, String password);
    User findByUsername(String username);
}
