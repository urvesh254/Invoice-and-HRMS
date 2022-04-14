package com.itaims.ihs.dao;

import com.itaims.ihs.entity.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class VendorDao {
    @Autowired
    private EntityManager entityManager;


    public List<Vendor> getAll() {
        return entityManager.createQuery("FROM Vendor", Vendor.class).getResultList();
    }


    public Vendor get(long primaryKey) {
        return entityManager.find(Vendor.class, primaryKey);
    }


    public void save(Vendor object) {
        entityManager.persist(object);
    }


    public void update(Vendor object) {
        entityManager.merge(object);
    }


    public void delete(Vendor object) {
        entityManager.remove(object);
    }
}
