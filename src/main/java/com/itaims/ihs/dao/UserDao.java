package com.itaims.ihs.dao;

import com.itaims.ihs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private EntityManager entityManager;


    public List<User> getAll() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
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

    public User getByEmail(String email) {
        TypedQuery<User> query = entityManager.createQuery("FROM User WHERE email=:givenEmail", User.class);
        query.setParameter("givenEmail", email);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
