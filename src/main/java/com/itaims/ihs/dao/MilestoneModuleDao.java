package com.itaims.ihs.dao;

import com.itaims.ihs.entity.MilestoneModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MilestoneModuleDao {

    @Autowired
    private EntityManager entityManager;


    public List<MilestoneModule> getAll() {
        return entityManager.createQuery("FROM MilestoneModule", MilestoneModule.class).getResultList();
    }


    public MilestoneModule get(long primaryKey) {
        return entityManager.find(MilestoneModule.class, primaryKey);
    }


    public void save(MilestoneModule object) {
        entityManager.persist(object);
    }


    public void update(MilestoneModule object) {
        entityManager.merge(object);
    }


    public void delete(MilestoneModule object) {
        entityManager.remove(object);
    }
}
