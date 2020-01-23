package com.example.linkedin.repository;

import com.example.linkedin.entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SkillsRepository extends JpaRepository<Skills, Long> {
    List<Skills> findByUserId(Long userId);

    Optional<Skills> findById(Long id);

    List<Skills> findAll();
}