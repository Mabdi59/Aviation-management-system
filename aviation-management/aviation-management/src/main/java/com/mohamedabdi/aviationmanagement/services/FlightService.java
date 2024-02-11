package com.mohamedabdi.aviationmanagement.services;


import com.mohamedabdi.aviationmanagement.dao.FlightDao;
import com.mohamedabdi.aviationmanagement.models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FlightService {

    private final FlightDao flightDao;

    @Autowired
    public FlightService(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    public Flight addFlight(Flight flight) {
        return flightDao.insertFlight(flight);
    }

    public List<Flight> getAllFlights() {
        return flightDao.getAllFlights();
    }

    public Flight getFlightById(Long flightId) {
        return flightDao.getFlightById(flightId);
    }

    public boolean updateFlight(Flight flight) {
        return flightDao.updateFlight(flight);
    }

    public boolean deleteFlight(Long flightId) {
        return flightDao.deleteFlight(flightId);
    }
}
