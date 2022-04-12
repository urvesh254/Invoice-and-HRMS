package com.itaims.ihs.dao;

import com.itaims.ihs.entity.InvoiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class InvoiceDetailDao {
    @Autowired
    private EntityManager entityManager;


    public List<InvoiceDetail> getAll() {
        List<InvoiceDetail> invoiceDetails = entityManager.createQuery("FROM InvoiceDetail", InvoiceDetail.class).getResultList();
        return invoiceDetails;
    }


    public InvoiceDetail get(long primaryKey) {
        return entityManager.find(InvoiceDetail.class, primaryKey);
    }


    public void save(InvoiceDetail object) {
        entityManager.persist(object);
    }


    public void update(InvoiceDetail object) {
        entityManager.merge(object);
    }


    public void delete(InvoiceDetail object) {
        entityManager.remove(object);
    }
}
