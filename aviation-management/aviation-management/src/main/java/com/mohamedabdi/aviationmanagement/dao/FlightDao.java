package com.mohamedabdi.aviationmanagement.dao;

import com.mohamedabdi.aviationmanagement.models.Flight;
import java.util.List;
import java.util.Optional;

public interface FlightDao {
    Flight insertFlight(Flight flight);
    List<Flight> getAllFlights();
    Optional<Flight> getFlightById(Long flightId);
    boolean updateFlight(Flight flight);
    boolean deleteFlight(Long flightId);
}
