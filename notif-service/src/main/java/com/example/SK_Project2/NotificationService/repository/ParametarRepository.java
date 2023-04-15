package com.example.SK_Project2.NotificationService.repository;

import com.example.SK_Project2.NotificationService.domain.Parametar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParametarRepository extends JpaRepository<Parametar,Long> {
}
