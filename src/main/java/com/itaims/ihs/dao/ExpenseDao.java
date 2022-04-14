package com.itaims.ihs.dao;

import com.itaims.ihs.entity.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ExpenseDao {

    @Autowired
    private EntityManager entityManager;


    public List<Expense> getAll() {
        return entityManager.createQuery("FROM Expense", Expense.class).getResultList();
    }


    public Expense get(long primaryKey) {
        return entityManager.find(Expense.class, primaryKey);
    }


    public void save(Expense object) {
        entityManager.persist(object);
    }


    public void update(Expense object) {
        entityManager.merge(object);
    }


    public void delete(Expense object) {
        entityManager.remove(object);
    }
}
