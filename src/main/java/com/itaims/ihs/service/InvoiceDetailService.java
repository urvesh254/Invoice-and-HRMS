package com.itaims.ihs.service;

import com.itaims.ihs.dao.InvoiceDao;
import com.itaims.ihs.dao.InvoiceDetailDao;
import com.itaims.ihs.dao.ServiceDao;
import com.itaims.ihs.entity.Invoice;
import com.itaims.ihs.entity.InvoiceDetail;
import com.itaims.ihs.entity.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
public class InvoiceDetailService {
    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private ServiceDao serviceDao;

    @Autowired
    private InvoiceDetailDao invoiceDetailDao;


    @Transactional
    public List<InvoiceDetail> getAll() {
        return invoiceDetailDao.getAll();
    }

    @Transactional
    public InvoiceDetail get(long primaryKey) {
        return invoiceDetailDao.get(primaryKey);
    }

    @Transactional
    public void save(InvoiceDetail object) {
        Invoice invoice = invoiceDao.get(object.getInvoice().getId());
        Service service = serviceDao.get(object.getService().getId());
        object.setService(service);
        invoice.getInvoiceDetails().add(object);
    }

    @Transactional
    public void update(InvoiceDetail object) {
        Service service = serviceDao.get(object.getService().getId());
        object.setService(service);

        Invoice currInvoice = invoiceDao.get(object.getInvoice().getId());
        object.setInvoice(currInvoice);

        invoiceDetailDao.update(object);
    }

    @Transactional
    public void delete(long primaryKey) {
        InvoiceDetail invoiceDetail = invoiceDetailDao.get(primaryKey);
        invoiceDetailDao.delete(invoiceDetail);
    }
}
