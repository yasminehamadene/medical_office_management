package com.example.servicerendezvous.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.servicerendezvous.model.RendezVous;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
    
    // Rechercher les rendez-vous d'un patient
    List<RendezVous> findByPatientId(String patientId);
    
    // Rechercher les rendez-vous d'un praticien
    List<RendezVous> findByPraticienId(String praticienId);
} 