package com.example.SK_Project2.NotificationService.repository;

import com.example.SK_Project2.NotificationService.domain.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotificationTypeRepository extends JpaRepository<NotificationType, Long> {

    Optional<NotificationType> findNotificationTypeByName(String name);
}
