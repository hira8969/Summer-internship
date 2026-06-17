package com.library.model;

public record Book(
        Long id,
        String title,
        String author,
        String isbn,
        Integer year,
        String category,
        Integer copies,
        Integer available,
        String accent) {
}
