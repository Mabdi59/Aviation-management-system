package com.mohamedabdi.aviationmanagement.controllers;

import com.mohamedabdi.aviationmanagement.models.Flight;
import com.mohamedabdi.aviationmanagement.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        Flight newFlight = flightService.addFlight(flight);
        return ResponseEntity.ok(newFlight);
    }

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> flights = flightService.getAllFlights();
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable("id") Long flightId) {
        Flight flight = flightService.getFlightById(flightId);
        return ResponseEntity.ok(flight);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateFlight(@PathVariable("id") Long flightId, @RequestBody Flight flight) {
        flight.setFlightId(flightId);
        boolean updated = flightService.updateFlight(flight);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteFlight(@PathVariable("id") Long flightId) {
        boolean deleted = flightService.deleteFlight(flightId);
        return ResponseEntity.ok(deleted);
    }
}
