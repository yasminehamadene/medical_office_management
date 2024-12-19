package com.example.practitioner.service;

import com.example.practitioner.model.Practitioner;
import com.example.practitioner.repository.PractitionerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PractitionerService {
    private final PractitionerRepository practitionerRepository;

    public List<Practitioner> getAllPractitioners() {
        return practitionerRepository.findAll();
    }

    public Practitioner getPractitionerById(Long id) {
        return practitionerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Practitioner not found"));
    }

    public Practitioner createPractitioner(Practitioner practitioner) {
        return practitionerRepository.save(practitioner);
    }

    public Practitioner updatePractitioner(Long id, Practitioner practitioner) {
        Practitioner existingPractitioner = getPractitionerById(id);
        practitioner.setId(existingPractitioner.getId());
        return practitionerRepository.save(practitioner);
    }

    public void deletePractitioner(Long id) {
        practitionerRepository.deleteById(id);
    }
} 