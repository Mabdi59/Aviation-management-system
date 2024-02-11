package com.mohamedabdi.aviationmanagement.models;

import java.time.OffsetDateTime;

public class Flight {
    private Long flightId;
    private String flightNumber;
    private String aircraftType;
    private OffsetDateTime departureTime;
    private OffsetDateTime arrivalTime;
    private String departureAirportCode;
    private String arrivalAirportCode;
    private String status;

    // Constructors, Getters, and Setters
    public Flight() {}

    public Flight(Long flightId, String flightNumber, String aircraftType, OffsetDateTime departureTime, OffsetDateTime arrivalTime, String departureAirportCode, String arrivalAirportCode, String status) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.aircraftType = aircraftType;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureAirportCode = departureAirportCode;
        this.arrivalAirportCode = arrivalAirportCode;
        this.status = status;
    }

    // Getters and setters

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public OffsetDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(OffsetDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public OffsetDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(OffsetDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
