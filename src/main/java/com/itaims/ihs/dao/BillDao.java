package com.itaims.ihs.dao;

import com.itaims.ihs.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class BillDao {

    @Autowired
    private EntityManager entityManager;


    public List<Bill> getAll() {
        return entityManager.createQuery("FROM Bill", Bill.class).getResultList();
    }


    public Bill get(long primaryKey) {
        return entityManager.find(Bill.class, primaryKey);
    }


    public void save(Bill object) {
        entityManager.persist(object);
    }


    public void update(Bill object) {
        entityManager.merge(object);
    }


    public void delete(Bill object) {
        entityManager.remove(object);
    }
}
