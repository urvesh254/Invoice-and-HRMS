package com.itaims.ihs.dao;

import com.itaims.ihs.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DepartmentDao {

    @Autowired
    private EntityManager entityManager;


    public List<Department> getAll() {
        return entityManager.createQuery("FROM Department", Department.class).getResultList();
    }


    public Department get(long primaryKey) {
        return entityManager.find(Department.class, primaryKey);
    }


    public void save(Department object) {
        entityManager.persist(object);
    }


    public void update(Department object) {
        entityManager.merge(object);
    }


    public void delete(Department object) {
        entityManager.remove(object);
    }
}
