package com.ashenh.sms.repository;

import com.ashenh.sms.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Students, Long> {
    Optional<Students> findByEmail(String email);
}
