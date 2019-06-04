package com.journaldev.spring.dao;

import com.journaldev.spring.model.User;

import java.util.List;

public interface IUserDAO {

    public void addUser(User user);
    public List<User> listUsers();
    public User getPersonById(int id);

}
