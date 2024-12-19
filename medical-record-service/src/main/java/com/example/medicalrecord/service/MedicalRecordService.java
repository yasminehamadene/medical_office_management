package com.example.medicalrecord.service;

import com.example.medicalrecord.model.MedicalRecord;
import com.example.medicalrecord.repository.MedicalRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalRecordService {
    private final MedicalRecordRepository medicalRecordRepository;

    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordRepository.findAll();
    }

    public MedicalRecord getMedicalRecordById(Long id) {
        return medicalRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medical Record not found"));
    }

    public List<MedicalRecord> getMedicalRecordsByPatient(Long patientId) {
        return medicalRecordRepository.findByPatientId(patientId);
    }

    public List<MedicalRecord> getMedicalRecordsByPractitioner(Long practitionerId) {
        return medicalRecordRepository.findByPractitionerId(practitionerId);
    }

    public MedicalRecord createMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordRepository.save(medicalRecord);
    }

    public MedicalRecord updateMedicalRecord(Long id, MedicalRecord medicalRecord) {
        MedicalRecord existingRecord = getMedicalRecordById(id);
        medicalRecord.setId(existingRecord.getId());
        return medicalRecordRepository.save(medicalRecord);
    }

    public void deleteMedicalRecord(Long id) {
        medicalRecordRepository.deleteById(id);
    }
} 