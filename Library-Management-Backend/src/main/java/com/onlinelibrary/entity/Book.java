package com.onlinelibrary.entity;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDateTime;

@Entity

@Table(name="books")

@Getter

@Setter

@NoArgsConstructor

@AllArgsConstructor

@Builder

public class Book {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable=false)

    private String title;

    @Column(nullable=false)

    private String author;

    @Column(nullable=false)

    private String category;

    @Column(nullable=false,length=5000)

    private String description;

    @Column(nullable=false)

    private Double rating;

    private LocalDateTime createdAt;

    @PrePersist

    public void setDate(){

        createdAt=LocalDateTime.now();

    }

}