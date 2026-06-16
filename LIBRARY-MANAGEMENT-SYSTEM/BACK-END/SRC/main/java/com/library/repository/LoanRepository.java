package com.library.repository;

import com.library.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    boolean existsByBookIdAndReturnedFalse(Long bookId);

    List<Loan> findByReturnedFalseOrderByIdDesc();
}
