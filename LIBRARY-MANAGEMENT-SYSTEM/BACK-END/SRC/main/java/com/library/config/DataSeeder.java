package com.library.config;

import com.library.model.Book;
import com.library.model.Loan;
import com.library.model.Member;
import com.library.repository.BookRepository;
import com.library.repository.LoanRepository;
import com.library.repository.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Base64;

@Component
public class DataSeeder implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final LoanRepository loanRepository;
    private final SecureRandom secureRandom = new SecureRandom();

    public DataSeeder(BookRepository bookRepository,
                      MemberRepository memberRepository,
                      LoanRepository loanRepository) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
        this.loanRepository = loanRepository;
    }

    @Override
    public void run(String... args) {
        if (bookRepository.count() > 0 || memberRepository.count() > 0) {
            return;
        }

        Book firstBook = bookRepository.save(new Book(null, "To Kill a Mockingbird", "Harper Lee",
                "978-0-06-112008-4", 1960, "Fiction", 5, 3, "#e78259"));
        bookRepository.save(new Book(null, "1984", "George Orwell",
                "978-0-451-52493-2", 1949, "Fiction", 4, 2, "#4b7a6b"));
        bookRepository.save(new Book(null, "The Catcher in the Rye", "J.D. Salinger",
                "978-0-316-76948-0", 1951, "Fiction", 3, 1, "#405f89"));

        Member john = memberRepository.save(new Member(
                null, "John Doe", "john@example.com", "REG-101",
                LocalDate.of(2024, 1, 15), hashPassword("student123")));
        memberRepository.save(new Member(
                null, "Jane Smith", "jane@example.com", "REG-102",
                LocalDate.of(2024, 2, 20), hashPassword("student123")));

        if (loanRepository.count() == 0) {
            loanRepository.save(new Loan(null, firstBook.getId(), firstBook.getTitle(),
                    john.getId(), john.getName(), LocalDate.of(2024, 6, 1),
                    LocalDate.of(2024, 6, 15), false));
        }
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
}
