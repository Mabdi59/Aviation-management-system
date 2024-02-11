package com.mohamedabdi.aviationmanagement.models;

public class User {
    private Long userId;
    private String username;
    private String password;
    private String email;
    private Boolean isEmailVerified;
    private Boolean isAccountNonLocked;
    private Boolean isEnabled;
    private String role;

    // Constructors
    public User() {
    }

    public User(Long userId, String username, String password, String email, Boolean isEmailVerified, Boolean isAccountNonLocked, Boolean isEnabled, String role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isEmailVerified = isEmailVerified;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isEnabled = isEnabled;
        this.role = role;
    }

    // Getters and Setters

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    public Boolean getAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
