package com.mohamedabdi.aviationmanagement.dao;

import com.mohamedabdi.aviationmanagement.models.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PassengerDaoImpl implements PassengerDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PassengerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Passenger> passengerRowMapper = (rs, rowNum) -> {
        Passenger passenger = new Passenger();
        passenger.setPassengerId(rs.getLong("passenger_id"));
        passenger.setFullName(rs.getString("full_name"));
        passenger.setEmail(rs.getString("email"));
        passenger.setPhoneNumber(rs.getString("phone_number"));
        passenger.setSpecialRequirements(rs.getString("special_requirements"));
        return passenger;
    };

    @Override
    public List<Passenger> getAllPassengers() {
        String sql = "SELECT * FROM passengers";
        return jdbcTemplate.query(sql, passengerRowMapper);
    }

    @Override
    public Passenger getPassengerById(Long passengerId) {
        String sql = "SELECT * FROM passengers WHERE passenger_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{passengerId}, passengerRowMapper);
    }

    @Override
    public void addPassenger(Passenger passenger) {
        String sql = "INSERT INTO passengers (full_name, email, phone_number, special_requirements) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, passenger.getFullName(), passenger.getEmail(), passenger.getPhoneNumber(), passenger.getSpecialRequirements());
    }

    @Override
    public void updatePassenger(Passenger passenger) {
        String sql = "UPDATE passengers SET full_name = ?, email = ?, phone_number = ?, special_requirements = ? WHERE passenger_id = ?";
        jdbcTemplate.update(sql, passenger.getFullName(), passenger.getEmail(), passenger.getPhoneNumber(), passenger.getSpecialRequirements(), passenger.getPassengerId());
    }

    @Override
    public void deletePassenger(Long passengerId) {
        String sql = "DELETE FROM passengers WHERE passenger_id = ?";
        jdbcTemplate.update(sql, passengerId);
    }
}
