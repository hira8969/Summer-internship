package com.onlinelibrary.dto;

import jakarta.validation.constraints.*;

import lombok.*;

@Getter

@Setter

@NoArgsConstructor

@AllArgsConstructor

public class BookRequestDTO {

    @NotBlank

    private String title;

    @NotBlank

    private String author;

    @NotBlank

    private String category;

    @NotBlank

    private String description;

    @NotNull

    @Min(1)

    @Max(5)

    private Double rating;

}