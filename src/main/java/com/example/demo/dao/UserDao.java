package com.example.demo.dao;



import com.example.demo.model.User;

import java.util.List;

;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user, int id);

    void deleteUser(int id);

    User getUser(int id);

}

