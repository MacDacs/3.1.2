package com.example.demo.dao;

import com.example.demo.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(User user, int id) {
        User update = em.find(User.class,user.getId());
        if(update!=null) {
            update.setName(user.getName());
            update.setEmail(user.getEmail());
        }
    }

    @Override
    public void deleteUser(int id) {
        User userDelete = em.find(User.class, id);
        if (userDelete != null) {
            em.remove(em.find(User.class, id));
        }
    }

    @Override
    public User getUser(int id) {
        User user = null;
        user = em.find(User.class, id);
        return user;
    }
}
