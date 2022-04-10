package com.itaims.ihs.dao;

import com.itaims.ihs.entity.Milestone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MilestoneDao {
    @Autowired
    private EntityManager entityManager;


    public List<Milestone> getAll() {
        return entityManager.createQuery("FROM Milestone", Milestone.class).getResultList();
    }


    public Milestone get(long primaryKey) {
        return entityManager.find(Milestone.class, primaryKey);
    }


    public void save(Milestone object) {
        entityManager.persist(object);
    }


    public void update(Milestone object) {
        entityManager.merge(object);
    }


    public void delete(Milestone object) {
        entityManager.remove(object);
    }
}
