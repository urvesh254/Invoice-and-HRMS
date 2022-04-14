package com.itaims.ihs.service;

import com.itaims.ihs.dao.BillDao;
import com.itaims.ihs.dao.VendorDao;
import com.itaims.ihs.entity.Bill;
import com.itaims.ihs.entity.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillDao billDao;

    @Autowired
    private VendorDao vendorDao;

    @Transactional
    public List<Bill> getAll() {
        return billDao.getAll();
    }


    @Transactional
    public Bill get(long primaryKey) {
        return billDao.get(primaryKey);
    }


    @Transactional
    public void save(Bill object) {
        Vendor vendor = vendorDao.get(object.getVendor().getId());
        object.setVendor(vendor);
        vendor.getBills().add(object);
    }

    @Transactional
    public void update(Bill object) {
        billDao.update(object);
    }

    @Transactional
    public void delete(long primaryKey) {
        Bill bill = billDao.get(primaryKey);
        billDao.delete(bill);
    }
}
