package com.andersen.shop.dao;


import com.andersen.shop.model.Product;
import javax.persistence.*;
import java.util.List;

public class ProductDao {

    private EntityManager em;


    public Product add(Product newProduct) {
        return em.merge(newProduct);
    }

    public Product get(int id) {
        return em.find(Product.class, id);
    }

    public void delete(int id) {
        em.remove(get(id));
    }

    public void update(Product product) {
        em.merge(product);
    }

    public List<Product> getAll() {
        TypedQuery<Product> namedQuery = em.createNamedQuery("Product.getAll", Product.class);
        return namedQuery.getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
