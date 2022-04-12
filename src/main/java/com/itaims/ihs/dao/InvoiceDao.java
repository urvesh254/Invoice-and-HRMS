package com.itaims.ihs.dao;

import com.itaims.ihs.entity.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class InvoiceDao {

    @Autowired
    private EntityManager entityManager;


    public List<Invoice> getAll() {
        return entityManager.createQuery("FROM Invoice", Invoice.class).getResultList();
    }


    public Invoice get(long primaryKey) {
        return entityManager.find(Invoice.class, primaryKey);
    }


    public void save(Invoice object) {
        entityManager.persist(object);
    }


    public void update(Invoice object) {
        entityManager.merge(object);
    }


    public void delete(Invoice object) {
        entityManager.remove(object);
    }
}
