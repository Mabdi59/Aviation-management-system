package com.mohamedabdi.aviationmanagement.dao;

import com.mohamedabdi.aviationmanagement.models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public class FlightDaoImpl implements FlightDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FlightDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Flight> rowMapper = (rs, rowNum) -> new Flight(
            rs.getLong("flight_id"),
            rs.getString("flight_number"),
            rs.getString("aircraft_type"),
            rs.getObject("departure_time", OffsetDateTime.class),
            rs.getObject("arrival_time", OffsetDateTime.class),
            rs.getString("departure_airport_code"),
            rs.getString("arrival_airport_code"),
            rs.getString("status")
    );

    @Override
    public Flight insertFlight(Flight flight) {
        String sql = "INSERT INTO flights (flight_number, aircraft_type, departure_time, arrival_time, departure_airport_code, arrival_airport_code, status) VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING flight_id";
        Long newId = jdbcTemplate.queryForObject(sql, new Object[]{
                flight.getFlightNumber(), flight.getAircraftType(), flight.getDepartureTime(), flight.getArrivalTime(), flight.getDepartureAirportCode(), flight.getArrivalAirportCode(), flight.getStatus()}, (rs, rowNum) -> rs.getLong(1));
        flight.setFlightId(newId);
        return flight;
    }

    @Override
    public List<Flight> getAllFlights() {
        String sql = "SELECT * FROM flights";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Flight getFlightById(Long flightId) {
        String sql = "SELECT * FROM flights WHERE flight_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{flightId}, rowMapper);
    }

    @Override
    public boolean updateFlight(Flight flight) {
        String sql = "UPDATE flights SET flight_number = ?, aircraft_type = ?, departure_time = ?, arrival_time = ?, departure_airport_code = ?, arrival_airport_code = ?, status = ? WHERE flight_id = ?";
        return jdbcTemplate.update(sql,
                flight.getFlightNumber(),
                flight.getAircraftType(),
                flight.getDepartureTime(),
                flight.getArrivalTime(),
                flight.getDepartureAirportCode(),
                flight.getArrivalAirportCode(),
                flight.getStatus(),
                flight.getFlightId()) > 0;
    }

    @Override
    public boolean deleteFlight(Long flightId) {
        String sql = "DELETE FROM flights WHERE flight_id = ?";
        return jdbcTemplate.update(sql, flightId) > 0;
    }
}
