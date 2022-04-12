package com.itaims.ihs.service;

import com.itaims.ihs.dao.CurrencyDao;
import com.itaims.ihs.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyDao currencyDao;

    @Transactional
    public List<Currency> getAll() {
        return currencyDao.getAll();
    }


    @Transactional
    public Currency get(long primaryKey) {
        return currencyDao.get(primaryKey);
    }


    @Transactional
    public void save(Currency object) {
        currencyDao.save(object);
    }


    @Transactional
    public void update(Currency object) {
        currencyDao.update(object);
    }


    @Transactional
    public void delete(long primaryKey) {
        Currency currency = currencyDao.get(primaryKey);
        currencyDao.delete(currency);
    }
}
