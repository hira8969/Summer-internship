package com.library.model;

import java.time.LocalDate;

public record Loan(
        Long id,
        Long bookId,
        String bookTitle,
        Long memberId,
        String memberName,
        LocalDate issued,
        LocalDate due,
        Boolean returned) {
}
