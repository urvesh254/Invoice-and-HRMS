package com.itaims.ihs.dao;

import com.itaims.ihs.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class RoleDao {

    @Autowired
    private EntityManager entityManager;


    public List<Role> getAll() {
        List<Role> roles = entityManager.createQuery("FROM Role", Role.class).getResultList();
        return roles;
    }


    public Role get(long primaryKey) {
        return entityManager.find(Role.class, primaryKey);
    }


    public void save(Role object) {
        entityManager.persist(object);
    }


    public void update(Role object) {
        entityManager.merge(object);
    }


    public void delete(Role object) {
        object.getUsers().clear();
        entityManager.remove(object);
    }
}
