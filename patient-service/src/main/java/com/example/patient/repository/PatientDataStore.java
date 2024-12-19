package com.example.patient.repository;

import com.example.patient.model.Patient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class PatientDataStore {
    private final List<Patient> patients = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    public List<Patient> findAll() {
        return new ArrayList<>(patients);
    }

    public Patient findById(Long id) {
        return patients.stream()
                .filter(patient -> patient.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Patient save(Patient patient) {
        if (patient.getId() == null) {
            patient.setId(idCounter.incrementAndGet());
            patients.add(patient);
        } else {
            deleteById(patient.getId());
            patients.add(patient);
        }
        return patient;
    }

    public void deleteById(Long id) {
        patients.removeIf(patient -> patient.getId().equals(id));
    }
} 