package com.mohamedabdi.aviationmanagement.dao;

import com.mohamedabdi.aviationmanagement.models.Booking;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcBookingDao implements BookingDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcBookingDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Booking> rowMapper = (rs, rowNum) -> {
        Booking booking = new Booking();
        booking.setBookingId(rs.getLong("booking_id"));
        booking.setFlightId(rs.getLong("flight_id"));
        booking.setPassengerId(rs.getLong("passenger_id"));
        booking.setSeatNumber(rs.getString("seat_number"));
        booking.setBookingTime(rs.getTimestamp("booking_time").toLocalDateTime().atZone(ZoneId.systemDefault()));
        return booking;
    };

    @Override
    public void addBooking(Booking booking) {
        String sql = "INSERT INTO bookings (flight_id, passenger_id, seat_number, booking_time) VALUES (?, ?, ?, ?)";

        ZonedDateTime bookingTime = Optional.ofNullable(booking.getBookingTime()).orElse(ZonedDateTime.now(ZoneId.systemDefault()));

        jdbcTemplate.update(sql, booking.getFlightId(), booking.getPassengerId(), booking.getSeatNumber(), Timestamp.valueOf(bookingTime.toLocalDateTime()));
    }

    @Override
    public Booking getBookingById(Long bookingId) {
        String sql = "SELECT * FROM bookings WHERE booking_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{bookingId}, rowMapper);
    }

    @Override
    public List<Booking> getAllBookings() {
        String sql = "SELECT * FROM bookings";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void updateBooking(Booking booking) {
        String sql = "UPDATE bookings SET flight_id = ?, passenger_id = ?, seat_number = ?, booking_time = ? WHERE booking_id = ?";
        jdbcTemplate.update(sql, booking.getFlightId(), booking.getPassengerId(), booking.getSeatNumber(), Timestamp.valueOf(booking.getBookingTime().toLocalDateTime()), booking.getBookingId());
    }

    @Override
    public void deleteBooking(Long bookingId) {
        String sql = "DELETE FROM bookings WHERE booking_id = ?";
        jdbcTemplate.update(sql, bookingId);
    }
}
