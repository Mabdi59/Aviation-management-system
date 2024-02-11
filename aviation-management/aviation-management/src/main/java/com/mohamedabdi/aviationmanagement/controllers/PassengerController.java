package com.mohamedabdi.aviationmanagement.controllers;

import com.mohamedabdi.aviationmanagement.models.Passenger;
import com.mohamedabdi.aviationmanagement.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    private final PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers() {
        List<Passenger> passengers = passengerService.getAllPassengers();
        return new ResponseEntity<>(passengers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable("id") Long id) {
        Passenger passenger = passengerService.getPassengerById(id);
        return new ResponseEntity<>(passenger, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Passenger> addPassenger(@RequestBody Passenger passenger) {
        passengerService.addPassenger(passenger);
        return new ResponseEntity<>(passenger, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Passenger> updatePassenger(@PathVariable("id") Long id, @RequestBody Passenger passenger) {
        passenger.setPassengerId(id);
        passengerService.updatePassenger(passenger);
        return new ResponseEntity<>(passenger, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable("id") Long id) {
        passengerService.deletePassenger(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(PassengerService.ServiceException.class)
    public ResponseEntity<String> handleServiceException(PassengerService.ServiceException e) {
        // Log exception, if necessary
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
