package com.mohamedabdi.aviationmanagement.controllers;

import com.mohamedabdi.aviationmanagement.models.Booking;
import com.mohamedabdi.aviationmanagement.services.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
        bookingService.addBooking(booking);
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable("id") Long id) {
        Booking booking = bookingService.getBookingById(id);
        return ResponseEntity.ok(booking);
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable("id") Long id, @RequestBody Booking booking) {
        booking.setBookingId(id);
        bookingService.updateBooking(booking);
        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable("id") Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.ok().build();
    }
}
