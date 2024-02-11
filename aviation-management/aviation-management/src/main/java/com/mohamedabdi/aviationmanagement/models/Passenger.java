package com.mohamedabdi.aviationmanagement.models;

public class Passenger {
    private Long passengerId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String specialRequirements;

    // Constructors
    public Passenger() {}

    public Passenger(Long passengerId, String fullName, String email, String phoneNumber, String specialRequirements) {
        this.passengerId = passengerId;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.specialRequirements = specialRequirements;
    }

    // Getters and Setters
    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSpecialRequirements() {
        return specialRequirements;
    }

    public void setSpecialRequirements(String specialRequirements) {
        this.specialRequirements = specialRequirements;
    }
}
