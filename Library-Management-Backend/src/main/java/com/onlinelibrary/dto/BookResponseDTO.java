package com.onlinelibrary.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter

@Setter

@NoArgsConstructor

@AllArgsConstructor

@Builder

public class BookResponseDTO {

    private Long id;

    private String title;

    private String author;

    private String category;

    private String description;

    private Double rating;

    private LocalDateTime createdAt;

}