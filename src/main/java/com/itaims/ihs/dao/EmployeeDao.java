package com.itaims.ihs.dao;

import com.itaims.ihs.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDao {
    @Autowired
    private EntityManager entityManager;


    public List<Employee> getAll() {
        return entityManager.createQuery("FROM Employee", Employee.class).getResultList();
    }


    public Employee get(long primaryKey) {
        return entityManager.find(Employee.class, primaryKey);
    }


    public void save(Employee object) {
        entityManager.persist(object);
    }


    public void update(Employee object) {
        entityManager.merge(object);
    }


    public void delete(Employee object) {
        entityManager.remove(object);
    }
}
