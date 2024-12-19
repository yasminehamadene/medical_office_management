package com.example.patient.service;

import com.example.patient.model.Patient;
import com.example.patient.repository.PatientDataStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientDataStore patientDataStore;

    public List<Patient> getAllPatients() {
        return patientDataStore.findAll();
    }

    public Patient getPatientById(Long id) {
        Patient patient = patientDataStore.findById(id);
        if (patient == null) {
            throw new RuntimeException("Patient not found");
        }
        return patient;
    }

    public Patient createPatient(Patient patient) {
        return patientDataStore.save(patient);
    }

    public Patient updatePatient(Long id, Patient patient) {
        Patient existingPatient = getPatientById(id);
        patient.setId(existingPatient.getId());
        return patientDataStore.save(patient);
    }

    public void deletePatient(Long id) {
        patientDataStore.deleteById(id);
    }
} 