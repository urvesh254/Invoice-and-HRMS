package com.itaims.ihs.dao;

import com.itaims.ihs.entity.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class OptionDao {

    @Autowired
    private EntityManager entityManager;


    public List<Option> getAll() {
        return entityManager.createQuery("FROM Option", Option.class).getResultList();
    }


    public Option get(long primaryKey) {
        return entityManager.find(Option.class, primaryKey);
    }


    public void save(Option object) {
        entityManager.persist(object);
    }


    public void update(Option object) {
        entityManager.merge(object);
    }


    public void delete(Option object) {
        entityManager.remove(object);
    }
}
