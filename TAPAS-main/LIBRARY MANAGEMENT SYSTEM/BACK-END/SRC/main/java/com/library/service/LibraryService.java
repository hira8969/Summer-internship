package com.library.service;

import com.library.model.Book;
import com.library.model.Loan;
import com.library.model.Member;
import com.library.model.MemberRegistration;
import com.library.model.StudentLogin;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class LibraryService {

    private final AtomicLong bookIds = new AtomicLong(3);
    private final AtomicLong memberIds = new AtomicLong(2);
    private final AtomicLong loanIds = new AtomicLong(1);

    private final List<Book> books = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();
    private final List<Loan> loans = new ArrayList<>();
    private final Map<Long, String> passwordHashes = new HashMap<>();
    private final SecureRandom secureRandom = new SecureRandom();

    public LibraryService() {
        books.add(new Book(1L, "To Kill a Mockingbird", "Harper Lee",
                "978-0-06-112008-4", 1960, "Fiction", 5, 3, "#e78259"));
        books.add(new Book(2L, "1984", "George Orwell",
                "978-0-451-52493-2", 1949, "Fiction", 4, 2, "#4b7a6b"));
        books.add(new Book(3L, "The Catcher in the Rye", "J.D. Salinger",
                "978-0-316-76948-0", 1951, "Fiction", 3, 1, "#405f89"));

        Member john = new Member(
                1L, "John Doe", "john@example.com", "REG-101", LocalDate.of(2024, 1, 15));
        Member jane = new Member(
                2L, "Jane Smith", "jane@example.com", "REG-102", LocalDate.of(2024, 2, 20));
        members.add(john);
        members.add(jane);
        passwordHashes.put(john.id(), hashPassword("student123"));
        passwordHashes.put(jane.id(), hashPassword("student123"));

        loans.add(new Loan(1L, 1L, "To Kill a Mockingbird", 1L, "John Doe",
                LocalDate.of(2024, 6, 1), LocalDate.of(2024, 6, 15), false));
    }

    public synchronized List<Book> getBooks() {
        return List.copyOf(books);
    }

    public synchronized Book addBook(Book request) {
        int copies = request.copies() == null ? 1 : request.copies();
        Book book = new Book(
                bookIds.incrementAndGet(),
                request.title(),
                request.author(),
                request.isbn(),
                request.year(),
                request.category(),
                copies,
                copies,
                request.accent() == null ? "#e78259" : request.accent());
        books.add(0, book);
        return book;
    }

    public synchronized void deleteBook(Long bookId) {
        boolean hasActiveLoan = loans.stream()
                .anyMatch(loan -> loan.bookId().equals(bookId) && !Boolean.TRUE.equals(loan.returned()));

        if (hasActiveLoan) {
            throw new IllegalArgumentException("Return this book before deleting it");
        }

        books.remove(findBook(bookId));
    }

    public synchronized List<Member> getMembers() {
        return List.copyOf(members);
    }

    public synchronized Member addMember(MemberRegistration request) {
        if (request.password() == null || request.password().length() < 6) {
            throw new IllegalArgumentException("Password must contain at least 6 characters");
        }

        boolean emailExists = members.stream()
                .anyMatch(member -> member.email().equalsIgnoreCase(request.email()));
        if (emailExists) {
            throw new IllegalArgumentException("A member with this email already exists");
        }

        boolean registrationExists = members.stream()
                .anyMatch(member -> member.registrationNumber()
                        .equalsIgnoreCase(request.registrationNumber()));
        if (registrationExists) {
            throw new IllegalArgumentException("This registration number is already in use");
        }

        Member member = new Member(
                memberIds.incrementAndGet(),
                request.name(),
                request.email(),
                request.registrationNumber(),
                LocalDate.now());
        members.add(member);
        passwordHashes.put(member.id(), hashPassword(request.password()));
        return member;
    }

    public synchronized Member loginStudent(StudentLogin login) {
        Member member = members.stream()
                .filter(item -> item.name().equalsIgnoreCase(login.name()))
                .filter(item -> item.email().equalsIgnoreCase(login.email()))
                .filter(item -> item.registrationNumber()
                        .equalsIgnoreCase(login.registrationNumber()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid student credentials"));

        String storedHash = passwordHashes.get(member.id());
        if (storedHash == null || !passwordMatches(login.password(), storedHash)) {
            throw new IllegalArgumentException("Invalid student credentials");
        }

        return member;
    }

    public synchronized List<Loan> getLoans() {
        return List.copyOf(loans);
    }

    public synchronized Loan issueLoan(Loan request) {
        Book book = findBook(request.bookId());
        Member member = findMember(request.memberId());

        if (book.available() < 1) {
            throw new IllegalArgumentException("Book is not available");
        }

        replaceBook(book, new Book(
                book.id(), book.title(), book.author(), book.isbn(), book.year(),
                book.category(), book.copies(), book.available() - 1, book.accent()));

        Loan loan = new Loan(
                loanIds.incrementAndGet(),
                book.id(),
                book.title(),
                member.id(),
                member.name(),
                LocalDate.now(),
                LocalDate.now().plusDays(14),
                false);
        loans.add(0, loan);
        return loan;
    }

    public synchronized Loan returnLoan(Long loanId) {
        Loan loan = loans.stream()
                .filter(item -> item.id().equals(loanId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Loan not found"));

        if (Boolean.TRUE.equals(loan.returned())) {
            throw new IllegalArgumentException("Book has already been returned");
        }

        Book book = findBook(loan.bookId());
        replaceBook(book, new Book(
                book.id(), book.title(), book.author(), book.isbn(), book.year(),
                book.category(), book.copies(), book.available() + 1, book.accent()));

        Loan returnedLoan = new Loan(
                loan.id(), loan.bookId(), loan.bookTitle(), loan.memberId(),
                loan.memberName(), loan.issued(), loan.due(), true);
        loans.set(loans.indexOf(loan), returnedLoan);
        return returnedLoan;
    }

    private Book findBook(Long id) {
        return books.stream()
                .filter(book -> book.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
    }

    private Member findMember(Long id) {
        return members.stream()
                .filter(member -> member.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
    }

    private void replaceBook(Book oldBook, Book newBook) {
        books.set(books.indexOf(oldBook), newBook);
    }

    private String hashPassword(String password) {
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);

        PBEKeySpec specification = new PBEKeySpec(password.toCharArray(), salt, 65_536, 256);
        try {
            byte[] hash = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
                    .generateSecret(specification)
                    .getEncoded();
            return Base64.getEncoder().encodeToString(salt)
                    + ":"
                    + Base64.getEncoder().encodeToString(hash);
        } catch (GeneralSecurityException error) {
            throw new IllegalStateException("Could not secure the password", error);
        } finally {
            specification.clearPassword();
        }
    }

    private boolean passwordMatches(String password, String storedPassword) {
        String[] parts = storedPassword.split(":", 2);
        if (parts.length != 2) {
            return false;
        }

        byte[] salt = Base64.getDecoder().decode(parts[0]);
        byte[] expectedHash = Base64.getDecoder().decode(parts[1]);
        PBEKeySpec specification = new PBEKeySpec(
                password.toCharArray(), salt, 65_536, expectedHash.length * 8);

        try {
            byte[] actualHash = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
                    .generateSecret(specification)
                    .getEncoded();
            return MessageDigest.isEqual(expectedHash, actualHash);
        } catch (GeneralSecurityException error) {
            throw new IllegalStateException("Could not verify the password", error);
        } finally {
            specification.clearPassword();
        }
    }
}
