package com.example.appointment.repository;

import com.example.appointment.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPatientId(Long patientId);
    List<Appointment> findByPractitionerId(Long practitionerId);
    List<Appointment> findByDateTimeBetween(LocalDateTime start, LocalDateTime end);
} 