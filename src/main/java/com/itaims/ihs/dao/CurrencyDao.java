package com.itaims.ihs.dao;

import com.itaims.ihs.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CurrencyDao {

    @Autowired
    private EntityManager entityManager;


    public List<Currency> getAll() {
        return entityManager.createQuery("FROM Currency", Currency.class).getResultList();
    }


    public Currency get(long primaryKey) {
        return entityManager.find(Currency.class, primaryKey);
    }


    public void save(Currency object) {
        entityManager.persist(object);
    }


    public void update(Currency object) {
        entityManager.merge(object);
    }


    public void delete(Currency object) {
        entityManager.remove(object);
    }
}
