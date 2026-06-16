package com.library.model;

public record StudentLogin(
        String name,
        String email,
        String registrationNumber,
        String password) {
}
