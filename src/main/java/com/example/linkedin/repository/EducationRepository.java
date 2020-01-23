package com.example.linkedin.repository;

import com.example.linkedin.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EducationRepository extends JpaRepository<Education, Long> {
   List<Education> findByUserIdOrderByStartDate(Long userId);

    Optional<Education> findById(Long id);

    List<Education> findAll();
}