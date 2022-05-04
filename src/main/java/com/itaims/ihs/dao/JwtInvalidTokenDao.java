package com.itaims.ihs.dao;

import com.itaims.ihs.entity.JwtInvalidToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class JwtInvalidTokenDao {

    @Autowired
    private EntityManager entityManager;


    public List<JwtInvalidToken> getAll() {
        return entityManager.createQuery("FROM JwtInvalidToken", JwtInvalidToken.class).getResultList();
    }

    public JwtInvalidToken get(long primaryKey) {
        return entityManager.find(JwtInvalidToken.class, primaryKey);
    }

    public void save(JwtInvalidToken object) {
        entityManager.persist(object);
    }

    public void delete(JwtInvalidToken object) {
        entityManager.remove(object);
    }

    public JwtInvalidToken getByToken(String token) {
        TypedQuery<JwtInvalidToken> query = entityManager.createQuery("FROM JwtInvalidToken WHERE token=:givenToken", JwtInvalidToken.class);
        query.setParameter("givenToken", token);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
