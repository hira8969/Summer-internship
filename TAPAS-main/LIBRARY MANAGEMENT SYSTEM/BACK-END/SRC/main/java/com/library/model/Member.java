package com.library.model;

import java.time.LocalDate;

public record Member(
        Long id,
        String name,
        String email,
        String registrationNumber,
        LocalDate joined) {
}
