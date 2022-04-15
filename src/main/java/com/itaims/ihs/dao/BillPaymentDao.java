package com.itaims.ihs.dao;

import com.itaims.ihs.entity.BillPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class BillPaymentDao {
    @Autowired
    private EntityManager entityManager;


    public List<BillPayment> getAll() {
        return entityManager.createQuery("FROM BillPayment", BillPayment.class).getResultList();
    }


    public BillPayment get(long primaryKey) {
        return entityManager.find(BillPayment.class, primaryKey);
    }


    public void save(BillPayment object) {
        entityManager.persist(object);
    }


    public void update(BillPayment object) {
        entityManager.merge(object);
    }


    public void delete(BillPayment object) {
        entityManager.remove(object);
    }
}
