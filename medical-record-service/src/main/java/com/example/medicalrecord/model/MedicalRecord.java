package com.example.medicalrecord.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long patientId;
    private Long practitionerId;
    private LocalDateTime dateTime;
    private String diagnosis;
    private String treatment;
    private String prescription;
    private String notes;
    private String attachments; // Could be URLs to stored files
} 