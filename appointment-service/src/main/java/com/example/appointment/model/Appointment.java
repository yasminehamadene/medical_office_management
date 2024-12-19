package com.example.appointment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long patientId;
    private Long practitionerId;
    private LocalDateTime dateTime;
    private String reason;
    private String status; // SCHEDULED, COMPLETED, CANCELLED
    private String notes;
} 