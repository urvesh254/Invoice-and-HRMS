package com.itaims.ihs.service;

import com.itaims.ihs.dao.VendorDao;
import com.itaims.ihs.entity.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class VendorService {
    @Autowired
    private VendorDao vendorDao;

    @Transactional
    public List<Vendor> getAll() {
        return vendorDao.getAll();
    }


    @Transactional
    public Vendor get(long primaryKey) {
        return vendorDao.get(primaryKey);
    }


    @Transactional
    public void save(Vendor object) {
        vendorDao.save(object);
    }


    @Transactional
    public void update(Vendor object) {
        vendorDao.update(object);
    }


    @Transactional
    public void delete(long primaryKey) {
        Vendor vendor = vendorDao.get(primaryKey);
        vendorDao.delete(vendor);
    }
}
