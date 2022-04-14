package com.itaims.ihs.service;

import com.itaims.ihs.dao.ExpenseDao;
import com.itaims.ihs.entity.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseDao ExpenseDao;

    @Transactional
    public List<Expense> getAll() {
        return ExpenseDao.getAll();
    }


    @Transactional
    public Expense get(long primaryKey) {
        return ExpenseDao.get(primaryKey);
    }


    @Transactional
    public void save(Expense object) {
        ExpenseDao.save(object);
    }


    @Transactional
    public void update(Expense object) {
        ExpenseDao.update(object);
    }


    @Transactional
    public void delete(long primaryKey) {
        Expense expense = ExpenseDao.get(primaryKey);
        ExpenseDao.delete(expense);
    }
}
