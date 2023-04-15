package com.example.SK_Project2.RentalCarService.repository;


import com.example.SK_Project2.RentalCarService.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TypeRepository extends JpaRepository<Type,Long> {

    Optional<Type> findTypeByName(String name);

    Optional<Type> findTypeById(Long id);
}
