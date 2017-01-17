package com.andersen.shop.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "booking")
@NamedQuery(name = "Order.getAll", query = "select o from Booking o")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_product",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private Set<Product> products = new HashSet<>();

    @SuppressWarnings("unused")
    public Set<Product> getProducts() {
        return products;
    }

    @SuppressWarnings("unused")
    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    @Column(name = "date")

    private Date date;

    public Booking() {
    }

    public Booking(Customer customer, Date date) {
        this.customer = customer;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    @SuppressWarnings("unused")
    public Customer getCustomer() {
        return customer;
    }

    @SuppressWarnings("unused")
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @SuppressWarnings("unused")
    public Date getDate() {
        return date;
    }

    @SuppressWarnings("unused")
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", customer=" + customer +
                ", products=" + products +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;
        if (!id.equals(booking.id)) return false;
        if (!customer.equals(booking.customer)) return false;
        if (!products.equals(booking.products)) return false;
        return date.equals(booking.date);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + customer.hashCode();
        result = 31 * result + products.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }
}
