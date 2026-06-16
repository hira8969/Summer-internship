package com.onlinelibrary.service;

import com.onlinelibrary.dto.BookRequestDTO;

import com.onlinelibrary.dto.BookResponseDTO;

import com.onlinelibrary.entity.Book;

import com.onlinelibrary.exception.BookNotFoundException;

import com.onlinelibrary.mapper.BookMapper;

import com.onlinelibrary.repository.BookRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

@RequiredArgsConstructor

public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Override

    public List<BookResponseDTO> getAllBooks(){

        return repository.findAll()

                .stream()

                .map(BookMapper::toResponse)

                .toList();

    }

    @Override

    public BookResponseDTO getBookById(Long id){

        Book book = repository.findById(id)

                .orElseThrow(
                        () -> new BookNotFoundException(
                                "Book not found : "+id
                        )
                );

        return BookMapper.toResponse(book);

    }

    @Override

    public List<BookResponseDTO> getBooksByCategory(
            String category
    ){

        return repository.findByCategoryIgnoreCase(category)

                .stream()

                .map(BookMapper::toResponse)

                .toList();

    }

    @Override

    public List<BookResponseDTO> searchBooks(
            String query
    ){

        return repository

                .findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(
                        query,
                        query
                )

                .stream()

                .map(BookMapper::toResponse)

                .toList();

    }

    @Override

    public BookResponseDTO addBook(
            BookRequestDTO dto
    ){

        Book book = BookMapper.toEntity(dto);

        Book saved = repository.save(book);

        return BookMapper.toResponse(saved);

    }

    @Override

    public BookResponseDTO updateBook(
            Long id,
            BookRequestDTO dto
    ){

        Book book = repository.findById(id)

                .orElseThrow(
                        () -> new BookNotFoundException(
                                "Book not found : "+id
                        )
                );

        book.setTitle(dto.getTitle());

        book.setAuthor(dto.getAuthor());

        book.setCategory(dto.getCategory());

        book.setDescription(dto.getDescription());

        book.setRating(dto.getRating());

        Book updated = repository.save(book);

        return BookMapper.toResponse(updated);

    }

    @Override

    public void deleteBook(
            Long id
    ){

        Book book = repository.findById(id)

                .orElseThrow(
                        () -> new BookNotFoundException(
                                "Book not found : "+id
                        )
                );

        repository.delete(book);

    }

}