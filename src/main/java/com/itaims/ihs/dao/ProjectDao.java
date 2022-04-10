package com.itaims.ihs.dao;

import com.itaims.ihs.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProjectDao {

    @Autowired
    private EntityManager entityManager;


    public List<Project> getAll() {
        List<Project> projects = entityManager.createQuery("FROM Project", Project.class).getResultList();
        return projects;
    }


    public Project get(long primaryKey) {
        return entityManager.find(Project.class, primaryKey);
    }


    public void save(Project object) {
        entityManager.persist(object);
    }


    public void update(Project object) {
        entityManager.merge(object);
    }


    public void delete(Project object) {
        entityManager.remove(object);
    }
}
