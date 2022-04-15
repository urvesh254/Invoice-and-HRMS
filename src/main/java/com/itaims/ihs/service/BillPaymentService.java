package com.itaims.ihs.service;

import com.itaims.ihs.dao.BillDao;
import com.itaims.ihs.dao.BillPaymentDao;
import com.itaims.ihs.entity.Bill;
import com.itaims.ihs.entity.BillPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BillPaymentService {
    @Autowired
    private BillDao billDao;

    @Autowired
    private BillPaymentDao billPaymentDao;


    @Transactional
    public List<BillPayment> getAll() {
        return billPaymentDao.getAll();
    }

    @Transactional
    public BillPayment get(long primaryKey) {
        return billPaymentDao.get(primaryKey);
    }

    @Transactional
    public void save(BillPayment object) {
        Bill bill = billDao.get(object.getBill().getId());
        bill.getBillPayments().add(object);
    }

    @Transactional
    public void update(BillPayment object) {
        Bill currBill = billDao.get(object.getBill().getId());
        object.setBill(currBill);

        billPaymentDao.update(object);
    }

    @Transactional
    public void delete(long primaryKey) {
        BillPayment billPayment = billPaymentDao.get(primaryKey);
        billPaymentDao.delete(billPayment);
    }
}
