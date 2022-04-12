package com.itaims.ihs.dao;

import com.itaims.ihs.entity.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ServiceDao {

    @Autowired
    private EntityManager entityManager;


    public List<Service> getAll() {
        return entityManager.createQuery("FROM Service", Service.class).getResultList();
    }


    public Service get(long primaryKey) {
        return entityManager.find(Service.class, primaryKey);
    }


    public void save(Service object) {
        entityManager.persist(object);
    }


    public void update(Service object) {
        entityManager.merge(object);
    }


    public void delete(Service object) {
        entityManager.remove(object);
    }
}
