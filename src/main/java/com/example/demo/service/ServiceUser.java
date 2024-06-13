package com.example.demo.service;


import com.example.demo.model.User;

import java.util.List;

public interface ServiceUser {
    List<User> getUsers();

    User getUser(int id);

    void addUser(User user);

    void updateUser(User user, int id);

    void deleteUser(int id);
}
