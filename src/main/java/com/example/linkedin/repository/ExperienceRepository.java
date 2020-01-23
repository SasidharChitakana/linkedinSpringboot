package com.example.linkedin.repository;

import com.example.linkedin.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    List<Experience> findByUserIdOrderByStartDate(Long userId);

    Optional<Experience> findById(Long id);

    List<Experience> findAll();
}