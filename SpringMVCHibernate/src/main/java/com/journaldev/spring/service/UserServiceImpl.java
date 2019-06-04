package com.journaldev.spring.service;

import com.journaldev.spring.dao.UserDAOImpl;
import com.journaldev.spring.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserServiceImpl implements IUserService {

    private UserDAOImpl userDAO;

    public void setUserDAO(UserDAOImpl userDAO) { this.userDAO = userDAO; }

    @Override
    @Transactional
    public void addUser(User user) { this.userDAO.addUser(user); }

    @Override
    @Transactional
    public List<User> listUsers() { return this.userDAO.listUsers(); }

    @Override
    @Transactional
    public User getUserById(int id) { return this.userDAO.getPersonById(id); }

}
