package com.andersen.shop.dao;


import com.andersen.shop.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerDao {
    private EntityManager em;

    public Customer add(Customer newCustomer) {
        return em.merge(newCustomer);
    }

    public Customer get(int id) {
        return em.find(Customer.class, id);
    }

    public void delete(int id) {
        em.remove(get(id));
    }

    public void update(Customer customer) {
        em.merge(customer);
    }

    public List<Customer> getAll() {
        TypedQuery<Customer> namedQuery = em.createNamedQuery("Customer.getAll", Customer.class);
        return namedQuery.getResultList();
    }


    public void setEm(EntityManager em) {
        this.em = em;
    }
}
