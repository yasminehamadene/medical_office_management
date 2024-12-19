package com.example.practitioner.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.practitioner.model.Practitioner;
import com.example.practitioner.repository.PractitionerDataStore;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PractitionerService {
    private final PractitionerDataStore practitionerDataStore;

    public List<Practitioner> getAllPractitioners() {
        return practitionerDataStore.findAll();
    }

    public Practitioner getPractitionerById(Long id) {
        Practitioner practitioner = practitionerDataStore.findById(id);
        if (practitioner == null) {
            throw new RuntimeException("Practitioner not found");
        }
        return practitioner;
    }

    public Practitioner createPractitioner(Practitioner practitioner) {
        return practitionerDataStore.save(practitioner);
    }

    public Practitioner updatePractitioner(Long id, Practitioner practitioner) {
        Practitioner existingPractitioner = getPractitionerById(id);
        practitioner.setId(existingPractitioner.getId());
        return practitionerDataStore.save(practitioner);
    }

    public void deletePractitioner(Long id) {
        practitionerDataStore.deleteById(id);
    }
} 