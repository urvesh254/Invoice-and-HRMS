package com.itaims.ihs.dao;

import com.itaims.ihs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private EntityManager entityManager;


    public List<User> getAll() {
        List<User> users = entityManager.createQuery("FROM User", User.class).getResultList();
        return users;
    }


    public User get(long primaryKey) {
        return entityManager.find(User.class, primaryKey);
    }


    public void save(User object) {
        entityManager.persist(object);
    }


    public void update(User object) {
        entityManager.merge(object);
    }


    public void delete(User object) {
        entityManager.remove(object);
    }
}
