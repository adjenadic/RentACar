package com.example.SK_Project2.NotificationService.repository;

import com.example.SK_Project2.NotificationService.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
}
