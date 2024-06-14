package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ServiceUserImpl implements ServiceUser{

    private final UserDao userDao;

    @Autowired
    public ServiceUserImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUser(int id) {
       return userDao.getUser(id);
    }

    @Override
    @Transactional
    public void addUser(@Valid User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user, int id) {
        userDao.updateUser(user,id);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
