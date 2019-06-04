package com.journaldev.spring.service;

import com.journaldev.spring.model.User;

import java.util.List;

public interface IUserService {

    public void addUser(User user);
    public List<User> listUsers();
    public User getUserById(int id);

}
