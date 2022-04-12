package com.itaims.ihs.service;

import com.itaims.ihs.dao.CurrencyDao;
import com.itaims.ihs.dao.CustomerDao;
import com.itaims.ihs.dao.InvoiceDao;
import com.itaims.ihs.dao.ProjectDao;
import com.itaims.ihs.entity.Customer;
import com.itaims.ihs.entity.Invoice;
import com.itaims.ihs.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CurrencyDao currencyDao;


    @Transactional
    public List<Invoice> getAll() {
        return invoiceDao.getAll();
    }


    @Transactional
    public Invoice get(long primaryKey) {
        return invoiceDao.get(primaryKey);
    }


    @Transactional
    public void save(Invoice object) {
        Project project = projectDao.get(object.getProject().getId());
        Customer customer = customerDao.get(object.getCustomer().getId());

        project.getInvoices().add(object);
        customer.getInvoices().add(object);
    }

    @Transactional
    public void update(Invoice object) {
        invoiceDao.update(object);
    }

    @Transactional
    public void delete(long primaryKey) {
        Invoice invoice = invoiceDao.get(primaryKey);
        invoiceDao.delete(invoice);
    }
}
