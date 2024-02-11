package com.mohamedabdi.aviationmanagement.dao;

import com.mohamedabdi.aviationmanagement.models.Passenger;
import java.util.List;

public interface PassengerDao {
    List<Passenger> getAllPassengers();
    Passenger getPassengerById(Long passengerId);
    void addPassenger(Passenger passenger);
    void updatePassenger(Passenger passenger);
    void deletePassenger(Long passengerId);
}
