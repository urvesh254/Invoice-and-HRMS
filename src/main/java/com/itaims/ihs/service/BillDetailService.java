package com.itaims.ihs.service;

import com.itaims.ihs.dao.BillDao;
import com.itaims.ihs.dao.BillDetailDao;
import com.itaims.ihs.entity.Bill;
import com.itaims.ihs.entity.BillDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BillDetailService {
    @Autowired
    private BillDao billDao;

    @Autowired
    private BillDetailDao billDetailDao;


    @Transactional
    public List<BillDetail> getAll() {
        return billDetailDao.getAll();
    }

    @Transactional
    public BillDetail get(long primaryKey) {
        return billDetailDao.get(primaryKey);
    }

    @Transactional
    public void save(BillDetail object) {
        Bill bill = billDao.get(object.getBill().getId());
        bill.getBillDetails().add(object);
    }

    @Transactional
    public void update(BillDetail object) {

        Bill currBill = billDao.get(object.getBill().getId());
        object.setBill(currBill);

        billDetailDao.update(object);
    }

    @Transactional
    public void delete(long primaryKey) {
        BillDetail billDetail = billDetailDao.get(primaryKey);
        billDetailDao.delete(billDetail);
    }
}
