package com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.impl;

import com.gmail.at.rospopa.pavlo.testingsystem.entities.Role;
import com.gmail.at.rospopa.pavlo.testingsystem.entities.User;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.UserDao;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.impl.jdbc.JdbcExecutant;
import com.gmail.at.rospopa.pavlo.testingsystem.persistence.dao.impl.jdbc.mappers.UserMapper;

import java.sql.*;
import java.util.List;

public class JdbcUserDao implements UserDao {

    private static final String FIND_ALL_SQL = "SELECT users.id, users.name, users.surname, users.username," +
            " users.password, users.email, roles.role FROM users JOIN roles ON users.role_id=roles.id";
    private static final String FIND_BY_ID_SQL = "SELECT users.id, users.name, users.surname, users.username," +
            " users.password, users.email, roles.role FROM users JOIN roles ON users.role_id=roles.id " +
            "WHERE users.id=?";
    private static final String FIND_ALL_USERS_WITH_ROLE_SQL = "SELECT users.id, users.name, users.surname, users.username," +
            " users.password, users.email, roles.role FROM users JOIN roles ON users.role_id=roles.id " +
            "WHERE roles.role=?";
    private static final String FIND_BY_USERNAME_PASSWORD_SQL = "SELECT users.id, users.name, users.surname, users.username," +
            " users.password, users.email, roles.role FROM users JOIN roles ON users.role_id=roles.id " +
            "WHERE users.username=? AND users.password=?";
    private static final String DELETE_SQL = "DELETE FROM users WHERE id=?";
    private static final String UPDATE_SQL = "UPDATE users SET name=?, surname=?, username=?, password=?, email=?, " +
            "role_id=? WHERE id=?";
    private static final String INSERT_SQL = "INSERT INTO users (name, surname, username, password, email, role_id) " +
            "VALUES (?, ?, ?, ?, ?, ?)";
    private static final String FIND_ROLE_ID_SQL = "SELECT id FROM roles WHERE role=?";

    private JdbcExecutant<User> jdbcExecutant;

    public JdbcUserDao(Connection connection) {
        jdbcExecutant = new JdbcExecutant<>(connection, new UserMapper());
    }

    @Override
    public List<User> findAllStudents() {
        return jdbcExecutant.executeQuery(FIND_ALL_USERS_WITH_ROLE_SQL, Role.STUDENT.toString());
    }

    @Override
    public User findByUsernamePassword(String username, String password) {
        return jdbcExecutant.executeQuery(FIND_BY_USERNAME_PASSWORD_SQL, username, password).get(0);
    }

    @Override
    public List<User> findAll() {
        return jdbcExecutant.executeQuery(FIND_ALL_SQL);
    }

    @Override
    public User findById(Long id) {
        return jdbcExecutant.executeQuery(FIND_BY_ID_SQL, id).get(0);
    }

    @Override
    public int delete(User entity) {
        return jdbcExecutant.executeUpdate(DELETE_SQL, entity.getId());
    }

    @Override
    public int delete(Long id) {
        return jdbcExecutant.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public int update(User entity) {
        return jdbcExecutant.executeUpdate(UPDATE_SQL, entity.getName(), entity.getSurname(), entity.getUsername(),
                entity.getPassword(), entity.getEmail(), findRoleId(entity.getRole()), entity.getId());
    }

    @Override
    public Long findRoleId(Role role){
        return jdbcExecutant.findRoleId(FIND_ROLE_ID_SQL, role.toString());
    }

    @Override
    public Long add(User entity) {
        return jdbcExecutant.executeInsert(INSERT_SQL, entity.getName(), entity.getSurname(), entity.getUsername(),
                entity.getPassword(), entity.getEmail(), findRoleId(entity.getRole()));
    }
}
