package com.onlinelibrary.mapper;

import com.onlinelibrary.dto.BookRequestDTO;

import com.onlinelibrary.dto.BookResponseDTO;

import com.onlinelibrary.entity.Book;

public class BookMapper {

    private BookMapper(){}

    public static Book toEntity(BookRequestDTO dto){

        return Book.builder()

                .title(dto.getTitle())

                .author(dto.getAuthor())

                .category(dto.getCategory())

                .description(dto.getDescription())

                .rating(dto.getRating())

                .build();
    }

    public static BookResponseDTO toResponse(Book book){

        return BookResponseDTO.builder()

                .id(book.getId())

                .title(book.getTitle())

                .author(book.getAuthor())

                .category(book.getCategory())

                .description(book.getDescription())

                .rating(book.getRating())

                .createdAt(book.getCreatedAt())

                .build();
    }

}