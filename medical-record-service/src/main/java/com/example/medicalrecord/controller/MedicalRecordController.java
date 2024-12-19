package com.example.medicalrecord.controller;

import com.example.medicalrecord.model.MedicalRecord;
import com.example.medicalrecord.service.MedicalRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-records")
@RequiredArgsConstructor
public class MedicalRecordController {
    private final MedicalRecordService medicalRecordService;

    @GetMapping
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordService.getAllMedicalRecords();
    }

    @GetMapping("/{id}")
    public MedicalRecord getMedicalRecordById(@PathVariable Long id) {
        return medicalRecordService.getMedicalRecordById(id);
    }

    @GetMapping("/patient/{patientId}")
    public List<MedicalRecord> getMedicalRecordsByPatient(@PathVariable Long patientId) {
        return medicalRecordService.getMedicalRecordsByPatient(patientId);
    }

    @GetMapping("/practitioner/{practitionerId}")
    public List<MedicalRecord> getMedicalRecordsByPractitioner(@PathVariable Long practitionerId) {
        return medicalRecordService.getMedicalRecordsByPractitioner(practitionerId);
    }

    @PostMapping
    public MedicalRecord createMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        return medicalRecordService.createMedicalRecord(medicalRecord);
    }

    @PutMapping("/{id}")
    public MedicalRecord updateMedicalRecord(@PathVariable Long id, @RequestBody MedicalRecord medicalRecord) {
        return medicalRecordService.updateMedicalRecord(id, medicalRecord);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalRecord(@PathVariable Long id) {
        medicalRecordService.deleteMedicalRecord(id);
        return ResponseEntity.ok().build();
    }
} 