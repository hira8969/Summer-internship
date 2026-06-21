package com.library.controller;

import com.library.model.Book;
import com.library.model.Loan;
import com.library.model.Member;
import com.library.model.MemberRegistration;
import com.library.model.StudentLogin;
import com.library.service.LibraryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return libraryService.getBooks();
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return libraryService.addBook(book);
    }

    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        libraryService.deleteBook(id);
    }

    @GetMapping("/members")
    public List<Member> getMembers() {
        return libraryService.getMembers();
    }

    @PostMapping("/members")
    @ResponseStatus(HttpStatus.CREATED)
    public Member addMember(@RequestBody MemberRegistration registration) {
        return libraryService.addMember(registration);
    }

    @PostMapping("/auth/student/login")
    public Member loginStudent(@RequestBody StudentLogin login) {
        return libraryService.loginStudent(login);
    }

    @GetMapping("/loans")
    public List<Loan> getLoans() {
        return libraryService.getLoans();
    }

    @GetMapping("/loans/active")
    public List<Loan> getActiveLoans() {
        return libraryService.getActiveLoans();
    }

    @PostMapping("/loans")
    @ResponseStatus(HttpStatus.CREATED)
    public Loan issueLoan(@RequestBody Loan loan) {
        return libraryService.issueLoan(loan);
    }

    @PutMapping("/loans/{id}/return")
    public Loan returnLoan(@PathVariable Long id) {
        return libraryService.returnLoan(id);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleBadRequest(IllegalArgumentException error) {
        return Map.of("message", error.getMessage());
    }
}
