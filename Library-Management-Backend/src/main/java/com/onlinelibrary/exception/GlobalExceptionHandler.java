package com.onlinelibrary.exception;

import org.springframework.dao.DataIntegrityViolationException;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.validation.FieldError;

import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

import java.util.List;

@ControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(
            BookNotFoundException.class
    )

    public ResponseEntity<ApiError> handleBookNotFound(

            BookNotFoundException ex

    ) {

        ApiError error = ApiError.builder()

                .timestamp(LocalDateTime.now())

                .status(404)

                .message(ex.getMessage())

                .errors(List.of())

                .build();

        return new ResponseEntity<>(

                error,

                HttpStatus.NOT_FOUND

        );

    }

    @ExceptionHandler(
            MethodArgumentNotValidException.class
    )

    public ResponseEntity<ApiError> validation(

            MethodArgumentNotValidException ex

    ) {

        List<String> errors = ex

                .getBindingResult()

                .getFieldErrors()

                .stream()

                .map(FieldError::getDefaultMessage)

                .toList();

        ApiError error = ApiError.builder()

                .timestamp(LocalDateTime.now())

                .status(400)

                .message("Validation Error")

                .errors(errors)

                .build();

        return new ResponseEntity<>(

                error,

                HttpStatus.BAD_REQUEST

        );

    }

    @ExceptionHandler(
            DataIntegrityViolationException.class
    )

    public ResponseEntity<ApiError> database(

            DataIntegrityViolationException ex

    ) {

        ApiError error = ApiError.builder()

                .timestamp(LocalDateTime.now())

                .status(409)

                .message("Database Conflict")

                .errors(List.of())

                .build();

        return new ResponseEntity<>(

                error,

                HttpStatus.CONFLICT

        );

    }

    @ExceptionHandler(
            Exception.class
    )

    public ResponseEntity<ApiError> generic(

            Exception ex

    ) {

        ApiError error = ApiError.builder()

                .timestamp(LocalDateTime.now())

                .status(500)

                .message(ex.getMessage())

                .errors(List.of())

                .build();

        return new ResponseEntity<>(

                error,

                HttpStatus.INTERNAL_SERVER_ERROR

        );

    }

}