package com.mohamedabdi.aviationmanagement.dao;

import com.mohamedabdi.aviationmanagement.models.Booking;

import java.util.List;

public interface BookingDao {
    void addBooking(Booking booking);
    Booking getBookingById(Long bookingId);
    List<Booking> getAllBookings();
    void updateBooking(Booking booking);
    void deleteBooking(Long bookingId);
}
