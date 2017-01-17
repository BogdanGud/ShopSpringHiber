package com.andersen.shop.service;


import com.andersen.shop.dao.CustomerDao;
import com.andersen.shop.model.Customer;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public class CustomerService {

    private CustomerDao customerDao;

    @Transactional
    public void create(Customer newCustomer) {
        customerDao.add(newCustomer);
    }

    @Transactional
    public Customer get(int id) {
        return customerDao.get(id);
    }

    @Transactional
    public void delete(int id) {
        customerDao.delete(id);
    }

    @Transactional
    public void update(Customer newCustomer) {
        customerDao.update(newCustomer);
    }

    @Transactional
    public List<Customer> getAll() {
        return customerDao.getAll();
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
