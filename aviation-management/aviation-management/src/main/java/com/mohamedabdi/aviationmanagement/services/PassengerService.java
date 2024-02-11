package com.mohamedabdi.aviationmanagement.services;

import com.mohamedabdi.aviationmanagement.dao.PassengerDao;
import com.mohamedabdi.aviationmanagement.models.Passenger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PassengerService {

    private static final Logger logger = LoggerFactory.getLogger(PassengerService.class);

    private final PassengerDao passengerDao;

    @Autowired
    public PassengerService(PassengerDao passengerDao) {
        this.passengerDao = passengerDao;
    }

    public List<Passenger> getAllPassengers() {
        try {
            return passengerDao.getAllPassengers();
        } catch (DataAccessException e) {
            logger.error("Error accessing the database", e);
            throw new ServiceException("Unable to retrieve passengers from the database.", e);
        }
    }

    public Passenger getPassengerById(Long passengerId) {
        try {
            return passengerDao.getPassengerById(passengerId);
        } catch (DataAccessException e) {
            logger.error("Error accessing the database for passenger ID: " + passengerId, e);
            throw new ServiceException("Unable to retrieve passenger with ID: " + passengerId, e);
        }
    }

    @Transactional
    public void addPassenger(Passenger passenger) {
        validatePassenger(passenger);
        try {
            passengerDao.addPassenger(passenger);
            // Future integration: notificationService.sendWelcomeEmail(passenger.getEmail());
        } catch (DataAccessException e) {
            logger.error("Error accessing the database when adding a new passenger", e);
            throw new ServiceException("Unable to add the passenger to the database.", e);
        }
    }

    @Transactional
    public void updatePassenger(Passenger passenger) {
        validatePassenger(passenger);
        try {
            passengerDao.updatePassenger(passenger);
        } catch (DataAccessException e) {
            logger.error("Error accessing the database when updating passenger ID: " + passenger.getPassengerId(), e);
            throw new ServiceException("Unable to update the passenger with ID: " + passenger.getPassengerId(), e);
        }
    }

    public void deletePassenger(Long passengerId) {
        try {
            passengerDao.deletePassenger(passengerId);
        } catch (DataAccessException e) {
            logger.error("Error accessing the database when deleting passenger ID: " + passengerId, e);
            throw new ServiceException("Unable to delete the passenger with ID: " + passengerId, e);
        }
    }

    private void validatePassenger(Passenger passenger) {
        if (passenger.getFullName() == null || passenger.getFullName().trim().isEmpty()) {
            throw new IllegalArgumentException("Passenger full name is required.");
        }
    }

    public static class ServiceException extends RuntimeException {
        public ServiceException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
