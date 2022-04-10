package com.itaims.ihs.dao;

import com.itaims.ihs.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerDao {

    @Autowired
    private EntityManager entityManager;


    public List<Customer> getAll() {
        List<Customer> customers = entityManager.createQuery("FROM Customer", Customer.class).getResultList();
        return customers;
    }


    public Customer get(long primaryKey) {
        return entityManager.find(Customer.class, primaryKey);
    }


    public void save(Customer object) {
        entityManager.persist(object);
    }


    public void update(Customer object) {
        entityManager.merge(object);
    }


    /* Never use this method. */
    private void delete(Customer object) {
        entityManager.remove(object);
    }
}
