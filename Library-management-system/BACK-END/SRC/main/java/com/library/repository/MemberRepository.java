package com.library.repository;

import com.library.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByEmailIgnoreCase(String email);

    boolean existsByRegistrationNumberIgnoreCase(String registrationNumber);

    Optional<Member> findByNameIgnoreCaseAndEmailIgnoreCaseAndRegistrationNumberIgnoreCase(
            String name, String email, String registrationNumber);
}
