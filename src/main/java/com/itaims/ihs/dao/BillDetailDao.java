package com.itaims.ihs.dao;

import com.itaims.ihs.entity.BillDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class BillDetailDao {
    @Autowired
    private EntityManager entityManager;


    public List<BillDetail> getAll() {
        List<BillDetail> invoiceDetails = entityManager.createQuery("FROM BillDetail", BillDetail.class).getResultList();
        return invoiceDetails;
    }


    public BillDetail get(long primaryKey) {
        return entityManager.find(BillDetail.class, primaryKey);
    }


    public void save(BillDetail object) {
        entityManager.persist(object);
    }


    public void update(BillDetail object) {
        entityManager.merge(object);
    }


    public void delete(BillDetail object) {
        entityManager.remove(object);
    }
}
