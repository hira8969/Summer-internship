package com.library.model;

public record MemberRegistration(
        String name,
        String email,
        String registrationNumber,
        String password) {
}
