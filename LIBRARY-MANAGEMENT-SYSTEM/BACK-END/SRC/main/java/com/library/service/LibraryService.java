package com.library.service;

import com.library.model.Book;
import com.library.model.Loan;
import com.library.model.Member;
import com.library.model.MemberRegistration;
import com.library.model.StudentLogin;
import com.library.repository.BookRepository;
import com.library.repository.LoanRepository;
import com.library.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

@Service
public class LibraryService {

    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final LoanRepository loanRepository;
    private final SecureRandom secureRandom = new SecureRandom();

    public LibraryService(BookRepository bookRepository,
                          MemberRepository memberRepository,
                          LoanRepository loanRepository) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
        this.loanRepository = loanRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book request) {
        if (request.getTitle() == null || request.getTitle().isBlank()) {
            throw new IllegalArgumentException("Book title is required");
        }

        if (request.getIsbn() == null || request.getIsbn().isBlank()) {
            throw new IllegalArgumentException("ISBN is required");
        }

        if (bookRepository.existsByIsbnIgnoreCase(request.getIsbn())) {
            throw new IllegalArgumentException("A book with this ISBN already exists");
        }

        int copies = request.getCopies() == null ? 1 : request.getCopies();
        Book book = new Book(
                null,
                request.getTitle(),
                request.getAuthor(),
                request.getIsbn(),
                request.getYear(),
                request.getCategory(),
                copies,
                copies,
                request.getAccent() == null ? "#e78259" : request.getAccent());
        return bookRepository.save(book);
    }

    public void deleteBook(Long bookId) {
        if (loanRepository.existsByBookIdAndReturnedFalse(bookId)) {
            throw new IllegalArgumentException("Return this book before deleting it");
        }

        Book book = findBook(bookId);
        bookRepository.delete(book);
    }

    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    public Member addMember(MemberRegistration request) {
        if (request.password() == null || request.password().length() < 6) {
            throw new IllegalArgumentException("Password must contain at least 6 characters");
        }

        if (memberRepository.existsByEmailIgnoreCase(request.email())) {
            throw new IllegalArgumentException("A member with this email already exists");
        }

        if (memberRepository.existsByRegistrationNumberIgnoreCase(request.registrationNumber())) {
            throw new IllegalArgumentException("This registration number is already in use");
        }

        Member member = new Member(
                null,
                request.name(),
                request.email(),
                request.registrationNumber(),
                LocalDate.now(),
                hashPassword(request.password()));
        return memberRepository.save(member);
    }

    public Member loginStudent(StudentLogin login) {
        Member member = memberRepository
                .findByNameIgnoreCaseAndEmailIgnoreCaseAndRegistrationNumberIgnoreCase(
                        login.name(), login.email(), login.registrationNumber())
                .orElseThrow(() -> new IllegalArgumentException("Invalid student credentials"));

        if (!passwordMatches(login.password(), member.getPasswordHash())) {
            throw new IllegalArgumentException("Invalid student credentials");
        }

        return member;
    }

    public List<Loan> getLoans() {
        return loanRepository.findAll();
    }

    public List<Loan> getActiveLoans() {
        return loanRepository.findByReturnedFalseOrderByIdDesc();
    }

    @Transactional
    public Loan issueLoan(Loan request) {
        Book book = findBook(request.getBookId());
        Member member = findMember(request.getMemberId());

        if (book.getAvailable() < 1) {
            throw new IllegalArgumentException("Book is not available");
        }

        book.setAvailable(book.getAvailable() - 1);
        bookRepository.save(book);

        Loan loan = new Loan(
                null,
                book.getId(),
                book.getTitle(),
                member.getId(),
                member.getName(),
                LocalDate.now(),
                LocalDate.now().plusDays(14),
                false);
        return loanRepository.save(loan);
    }

    @Transactional
    public Loan returnLoan(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new IllegalArgumentException("Loan not found"));

        if (Boolean.TRUE.equals(loan.getReturned())) {
            throw new IllegalArgumentException("Book has already been returned");
        }

        Book book = findBook(loan.getBookId());
        book.setAvailable(book.getAvailable() + 1);
        bookRepository.save(book);

        loan.setReturned(true);
        return loanRepository.save(loan);
    }

    private Book findBook(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
    }

    private Member findMember(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
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
