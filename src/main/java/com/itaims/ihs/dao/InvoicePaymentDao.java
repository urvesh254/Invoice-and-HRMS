package com.itaims.ihs.dao;

import com.itaims.ihs.entity.InvoicePayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class InvoicePaymentDao {
    @Autowired
    private EntityManager entityManager;


    public List<InvoicePayment> getAll() {
        return entityManager.createQuery("FROM InvoicePayment", InvoicePayment.class).getResultList();
    }


    public InvoicePayment get(long primaryKey) {
        return entityManager.find(InvoicePayment.class, primaryKey);
    }


    public void save(InvoicePayment object) {
        entityManager.persist(object);
    }


    public void update(InvoicePayment object) {
        entityManager.merge(object);
    }


    public void delete(InvoicePayment object) {
        entityManager.remove(object);
    }
}
