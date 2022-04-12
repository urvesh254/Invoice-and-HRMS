package com.itaims.ihs.service;

import com.itaims.ihs.dao.InvoiceDao;
import com.itaims.ihs.dao.InvoicePaymentDao;
import com.itaims.ihs.entity.Invoice;
import com.itaims.ihs.entity.InvoicePayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InvoicePaymentService {
    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private InvoicePaymentDao invoicePaymentDao;


    @Transactional
    public List<InvoicePayment> getAll() {
        return invoicePaymentDao.getAll();
    }

    @Transactional
    public InvoicePayment get(long primaryKey) {
        return invoicePaymentDao.get(primaryKey);
    }

    @Transactional
    public void save(InvoicePayment object) {
        Invoice invoice = invoiceDao.get(object.getInvoice().getId());
        invoice.getInvoicePayments().add(object);
    }

    @Transactional
    public void update(InvoicePayment object) {
        Invoice currInvoice = invoiceDao.get(object.getInvoice().getId());
        object.setInvoice(currInvoice);

        invoicePaymentDao.update(object);
    }

    @Transactional
    public void delete(long primaryKey) {
        InvoicePayment invoicePayment = invoicePaymentDao.get(primaryKey);
        invoicePaymentDao.delete(invoicePayment);
    }
}
