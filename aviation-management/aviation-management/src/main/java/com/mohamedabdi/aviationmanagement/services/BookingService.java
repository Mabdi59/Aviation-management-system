package com.mohamedabdi.aviationmanagement.services;

import com.mohamedabdi.aviationmanagement.dao.BookingDao;
import com.mohamedabdi.aviationmanagement.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingDao bookingDao;

    // Constructor-based dependency injection of the BookingDao
    @Autowired
    public BookingService(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    /**
     * Adds a new booking to the database.
     * @param booking The booking to be added.
     */
    public void addBooking(Booking booking) {
        bookingDao.addBooking(booking);
    }

    /**
     * Retrieves a booking by its ID.
     * @param bookingId The ID of the booking to retrieve.
     * @return The requested booking if found.
     */
    public Booking getBookingById(Long bookingId) {
        return Optional.ofNullable(bookingDao.getBookingById(bookingId))
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + bookingId));
    }

    /**
     * Retrieves all bookings from the database.
     * @return A list of all bookings.
     */
    public List<Booking> getAllBookings() {
        return bookingDao.getAllBookings();
    }

    /**
     * Updates the details of an existing booking.
     * @param booking The booking with updated details.
     */
    public void updateBooking(Booking booking) {
        bookingDao.updateBooking(booking);
    }

    /**
     * Deletes a booking by its ID.
     * @param bookingId The ID of the booking to delete.
     */
    public void deleteBooking(Long bookingId) {
        bookingDao.deleteBooking(bookingId);
    }
}
