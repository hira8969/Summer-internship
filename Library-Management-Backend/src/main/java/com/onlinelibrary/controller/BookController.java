package com.onlinelibrary.controller;

import com.onlinelibrary.dto.BookRequestDTO;
import com.onlinelibrary.dto.BookResponseDTO;
import com.onlinelibrary.service.BookService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/v1/books")

@RequiredArgsConstructor

public class BookController {

    private final BookService service;

    @GetMapping

    public ResponseEntity<List<BookResponseDTO>> getAllBooks() {

        return ResponseEntity.ok(
                service.getAllBooks()
        );

    }

    @GetMapping("/{id}")

    public ResponseEntity<BookResponseDTO> getBookById(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                service.getBookById(id)
        );

    }

    @GetMapping("/category/{category}")

    public ResponseEntity<List<BookResponseDTO>> getBooksByCategory(
            @PathVariable String category
    ) {

        return ResponseEntity.ok(
                service.getBooksByCategory(category)
        );

    }

    @GetMapping("/search")

    public ResponseEntity<List<BookResponseDTO>> searchBooks(
            @RequestParam String q
    ) {

        return ResponseEntity.ok(
                service.searchBooks(q)
        );

    }

    @PostMapping

    public ResponseEntity<BookResponseDTO> addBook(

            @Valid

            @RequestBody

            BookRequestDTO dto

    ) {

        return new ResponseEntity<>(

                service.addBook(dto),

                HttpStatus.CREATED

        );

    }

    @PutMapping("/{id}")

    public ResponseEntity<BookResponseDTO> updateBook(

            @PathVariable Long id,

            @Valid

            @RequestBody

            BookRequestDTO dto

    ) {

        return ResponseEntity.ok(

                service.updateBook(id, dto)

        );

    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deleteBook(

            @PathVariable Long id

    ) {

        service.deleteBook(id);

        return ResponseEntity.noContent().build();

    }

}