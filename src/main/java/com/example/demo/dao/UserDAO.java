package com.example.demo.dao;


import com.example.demo.model.User;

import java.util.List;

public interface UserDAO {
    List<User> listUsers();

    void addUser(User user);

    User userID(int id);

    void removeUserById(int id);

    void update(User user, int id);
}
