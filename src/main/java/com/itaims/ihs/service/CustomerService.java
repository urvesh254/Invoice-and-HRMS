package com.itaims.ihs.service;

import com.itaims.ihs.dao.CustomerDao;
import com.itaims.ihs.entity.Customer;
import com.itaims.ihs.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;


    @Transactional
    public List<Customer> getAll() {
        return customerDao.getAll();
    }


    @Transactional
    public Customer get(long primaryKey) {
        return customerDao.get(primaryKey);
    }


    @Transactional
    public void save(Customer object) {
        customerDao.save(object);
    }

    @Transactional
    public void update(Customer object) {
        customerDao.update(object);
    }

    @Transactional
    public void delete(long primaryKey) {
        Customer customer = customerDao.get(primaryKey);
        customer.setStatus(Status.INACTIVE);
    }
}
