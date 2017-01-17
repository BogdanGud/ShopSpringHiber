package com.andersen.shop.service;

import com.andersen.shop.dao.BookingDao;
import com.andersen.shop.dao.CustomerDao;
import com.andersen.shop.dao.ProductDao;
import com.andersen.shop.model.Booking;
import com.andersen.shop.model.Customer;
import com.andersen.shop.model.Product;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public class BookingService {
    private BookingDao bookingDao;
    private CustomerDao customerDao;
    private ProductDao productDao;

    @Transactional
    public void createNewOrder(int customerId, Date date, int productId) {
        Customer tempCustomer = customerDao.get(customerId);
        Product tempProduct = productDao.get(productId);
        Booking tempBooking = new Booking(tempCustomer, date);
        tempBooking.addProduct(tempProduct);
        bookingDao.add(tempBooking);
    }

    @Transactional
    public Booking get(int id) {
        return bookingDao.get(id);
    }

    @Transactional
    public void delete(int id) {
        bookingDao.delete(id);
    }

    @Transactional
    public void update(Booking newBooking) {
        bookingDao.update(newBooking);
    }

    @Transactional
    public List<Booking> getAll() {
        return bookingDao.getAll();
    }

    public void setBookingDao(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
}
