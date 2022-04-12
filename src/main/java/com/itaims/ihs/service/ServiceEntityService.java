package com.itaims.ihs.service;

import com.itaims.ihs.dao.ServiceDao;
import com.itaims.ihs.entity.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceEntityService {

    @Autowired
    private ServiceDao serviceDao;

    @Transactional
    public List<Service> getAll() {
        return serviceDao.getAll();
    }


    @Transactional
    public Service get(long primaryKey) {
        return serviceDao.get(primaryKey);
    }


    @Transactional
    public void save(Service object) {
        serviceDao.save(object);
    }


    @Transactional
    public void update(Service object) {
        serviceDao.update(object);
    }


    @Transactional
    public void delete(long primaryKey) {
        Service service = serviceDao.get(primaryKey);
        serviceDao.delete(service);
    }
}
