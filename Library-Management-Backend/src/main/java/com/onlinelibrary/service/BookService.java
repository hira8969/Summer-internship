package com.onlinelibrary.service;

import com.onlinelibrary.dto.BookRequestDTO;

import com.onlinelibrary.dto.BookResponseDTO;

import java.util.List;

public interface BookService {

    List<BookResponseDTO> getAllBooks();

    BookResponseDTO getBookById(Long id);

    List<BookResponseDTO> getBooksByCategory(
            String category
    );

    List<BookResponseDTO> searchBooks(
            String query
    );

    BookResponseDTO addBook(
            BookRequestDTO dto
    );

    BookResponseDTO updateBook(
            Long id,
            BookRequestDTO dto
    );

    void deleteBook(
            Long id
    );

}