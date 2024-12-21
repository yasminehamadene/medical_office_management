package com.example.servicerendezvous.service;

import java.util.List; // Ensure this import is present
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.servicerendezvous.model.RendezVous;
import com.example.servicerendezvous.repository.RendezVousRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class RendezVousService {

    @Autowired
    private RendezVousRepository rendezVousRepository;

    @Autowired
    private CalendarService calendarService;

    public List<RendezVous> getAllRendezVous() {
        return rendezVousRepository.findAll();
    }

    public Optional<RendezVous> getRendezVousById(Long id) {
        return rendezVousRepository.findById(id);
    }

    @CircuitBreaker(name = "rendezVousService")
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        // Sauvegarder dans la base de données
        RendezVous savedRendezVous = rendezVousRepository.save(rendezVous);
        
        // Créer l'événement dans Google Calendar
        calendarService.createCalendarEvent(savedRendezVous);
        
        return savedRendezVous;
    }

    public void deleteRendezVous(Long id) {
        rendezVousRepository.deleteById(id);
    }
} 