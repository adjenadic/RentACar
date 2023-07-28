package com.example.SK_Project2.NotificationService.repository;

import com.example.SK_Project2.NotificationService.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    Optional<Notification> findNotificationById(Long id);

}
