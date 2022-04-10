package com.itaims.ihs.dao;

import com.itaims.ihs.entity.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PermissionDao {

    @Autowired
    private EntityManager entityManager;


    public List<Permission> getAll() {
        return entityManager.createQuery("FROM Permission", Permission.class).getResultList();
    }


    public Permission get(long primaryKey) {
        return entityManager.find(Permission.class, primaryKey);
    }


    public void save(Permission object) {
        entityManager.persist(object);
    }


    public void update(Permission object) {
        entityManager.merge(object);
    }


    public void delete(Permission object) {
        entityManager.remove(object);
    }
}
