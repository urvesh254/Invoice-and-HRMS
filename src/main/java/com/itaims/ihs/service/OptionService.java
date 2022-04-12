package com.itaims.ihs.service;

import com.itaims.ihs.dao.OptionDao;
import com.itaims.ihs.entity.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OptionService {

    @Autowired
    private OptionDao optionDao;

    @Transactional
    public List<Option> getAll() {
        return optionDao.getAll();
    }


    @Transactional
    public Option get(long primaryKey) {
        return optionDao.get(primaryKey);
    }


    @Transactional
    public void save(Option object) {
        optionDao.save(object);
    }


    @Transactional
    public void update(Option object) {
        optionDao.update(object);
    }


    @Transactional
    public void delete(long primaryKey) {
        Option option = optionDao.get(primaryKey);
        optionDao.delete(option);
    }
}
