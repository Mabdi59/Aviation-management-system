-- Drop existing tables if they exist, starting with the ones that have foreign keys
DROP TABLE IF EXISTS bookings CASCADE;
DROP TABLE IF EXISTS passengers CASCADE;
DROP TABLE IF EXISTS flights CASCADE;
DROP TABLE IF EXISTS users CASCADE;

-- Create tables
CREATE TABLE flights (
    flight_id SERIAL PRIMARY KEY,
    flight_number VARCHAR(20) NOT NULL,
    aircraft_type VARCHAR(50),
    departure_time TIMESTAMP WITH TIME ZONE NOT NULL,
    arrival_time TIMESTAMP WITH TIME ZONE NOT NULL,
    departure_airport_code VARCHAR(10),
    arrival_airport_code VARCHAR(10),
    status VARCHAR(20) DEFAULT 'scheduled'
);

CREATE TABLE passengers (
    passenger_id SERIAL PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    phone_number VARCHAR(20),
    special_requirements TEXT
);

CREATE TABLE bookings (
    booking_id SERIAL PRIMARY KEY,
    flight_id INT NOT NULL,
    passenger_id INT NOT NULL,
    seat_number VARCHAR(10),
    booking_time TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (flight_id) REFERENCES flights(flight_id),
    FOREIGN KEY (passenger_id) REFERENCES passengers(passenger_id)
);

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    is_email_verified BOOLEAN DEFAULT FALSE,
    is_account_non_locked BOOLEAN DEFAULT TRUE,
    is_enabled BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    password_reset_token VARCHAR(255) NULL,
    password_reset_token_expiry TIMESTAMP WITH TIME ZONE NULL,
    role VARCHAR(50) NOT NULL
);

-- Create indexes after tables to ensure referenced columns exist
CREATE INDEX idx_flight_times ON flights(departure_time, arrival_time);
CREATE INDEX idx_passenger_email ON passengers(email);
