package com.ashenh.sms.repository;

import com.ashenh.sms.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Students, Long> {

}
