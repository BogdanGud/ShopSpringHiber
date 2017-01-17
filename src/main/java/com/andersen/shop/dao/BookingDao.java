package com.andersen.shop.dao;

import com.andersen.shop.model.Booking;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookingDao {
    private EntityManager em;

    public Booking add(Booking newBooking) {
        return em.merge(newBooking);
    }

    public Booking get(int id) {
        return em.find(Booking.class, id);
    }

    public void delete(int id) {
        em.remove(get(id));
    }

    public void update(Booking booking) {
        em.merge(booking);
    }

    public List<Booking> getAll() {
        TypedQuery<Booking> namedQuery = em.createNamedQuery("Order.getAll", Booking.class);
        return namedQuery.getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
