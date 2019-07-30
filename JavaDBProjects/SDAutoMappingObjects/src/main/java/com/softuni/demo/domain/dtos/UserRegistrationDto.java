package com.softuni.demo.domain.dtos;

import org.springframework.validation.annotation.Validated;

public class UserRegistrationDto {
    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;

    public UserRegistrationDto(String email, String password, String confirmPassword, String fullName) throws IllegalAccessException {
        this.email = email;
        this.password = password;
        this.setConfirmPassword(confirmPassword);
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) throws IllegalAccessException {
            if (confirmPassword.equals(password)) {
                this.confirmPassword = confirmPassword;
            } else {
                throw new IllegalCallerException("Confirm password must be exact match to password");
            }
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
