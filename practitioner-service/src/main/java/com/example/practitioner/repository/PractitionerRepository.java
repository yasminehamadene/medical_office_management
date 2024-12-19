package com.example.practitioner.repository;

import com.example.practitioner.model.Practitioner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PractitionerRepository extends JpaRepository<Practitioner, Long> {
} 