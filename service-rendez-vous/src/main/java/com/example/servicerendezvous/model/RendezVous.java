package com.example.servicerendezvous.model;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rendez_vous")
@Schema(description = "Modèle de rendez-vous")
public class RendezVous {
    
    private static int idGenerator = 0;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "L'ID du rendez-vous généré par la base de données")
    private Long id;
    
    @Schema(description = "Date et heure du rendez-vous")
    private LocalDateTime date;
    
    @Schema(description = "L'ID du patient")
    @Column(name = "patient_id", nullable = false)
    private String patientId;
    
    @Schema(description = "L'ID du praticien")
    @Column(name = "praticien_id", nullable = false)
    private String praticienId;
    
    @Schema(description = "La description du rendez-vous")
    private String description;

    // Constructeur par défaut
    public RendezVous() {
        this.id = (long) ++idGenerator;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPraticienId() {
        return praticienId;
    }

    public void setPraticienId(String praticienId) {
        this.praticienId = praticienId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
} 