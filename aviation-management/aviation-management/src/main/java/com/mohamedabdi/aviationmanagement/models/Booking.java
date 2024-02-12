package com.mohamedabdi.aviationmanagement.models;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Booking {
    private Long bookingId;
    private Long flightId;
    private Long passengerId;
    private String seatNumber;
    private ZonedDateTime bookingTime = ZonedDateTime.now(ZoneId.systemDefault());

    // Constructors
    public Booking() {
    }

    public Booking(Long bookingId, Long flightId, Long passengerId, String seatNumber, ZonedDateTime bookingTime) {
        this.bookingId = bookingId;
        this.flightId = flightId;
        this.passengerId = passengerId;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
    }

    // Getters and Setters
    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public ZonedDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(ZonedDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }
}
