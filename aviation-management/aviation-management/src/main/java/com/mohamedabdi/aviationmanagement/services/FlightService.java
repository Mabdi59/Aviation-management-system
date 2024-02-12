package com.mohamedabdi.aviationmanagement.services;

import com.mohamedabdi.aviationmanagement.dao.FlightDao;
import com.mohamedabdi.aviationmanagement.models.Flight;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FlightService {

    private final FlightDao flightDao;

    public FlightService(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    @Transactional
    public Flight addFlight(Flight flight) {
        return flightDao.insertFlight(flight);
    }

    public List<Flight> getAllFlights() {
        return flightDao.getAllFlights();
    }

    public Flight getFlightById(Long flightId) {
        return flightDao.getFlightById(flightId).orElseThrow(() -> new RuntimeException("Flight not found for id: " + flightId));
    }

    @Transactional
    public boolean updateFlight(Flight flight) {
        getFlightById(flight.getFlightId());
        return flightDao.updateFlight(flight);
    }

    @Transactional
    public boolean deleteFlight(Long flightId) {
        getFlightById(flightId);
        return flightDao.deleteFlight(flightId);
    }
}
