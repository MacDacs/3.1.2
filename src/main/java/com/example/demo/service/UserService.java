package com.example.demo.service;


import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();

    void addUser(User user);

    User userID(int id);

    void removeUserById(int id);

    void update(User user, int id);
}
