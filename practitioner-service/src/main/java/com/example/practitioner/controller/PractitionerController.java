package com.example.practitioner.controller;

import com.example.practitioner.model.Practitioner;
import com.example.practitioner.service.PractitionerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/practitioners")
@RequiredArgsConstructor
public class PractitionerController {
    private final PractitionerService practitionerService;

    @GetMapping
    public List<Practitioner> getAllPractitioners() {
        return practitionerService.getAllPractitioners();
    }

    @GetMapping("/{id}")
    public Practitioner getPractitionerById(@PathVariable Long id) {
        return practitionerService.getPractitionerById(id);
    }

    @PostMapping
    public Practitioner createPractitioner(@RequestBody Practitioner practitioner) {
        return practitionerService.createPractitioner(practitioner);
    }

    @PutMapping("/{id}")
    public Practitioner updatePractitioner(@PathVariable Long id, @RequestBody Practitioner practitioner) {
        return practitionerService.updatePractitioner(id, practitioner);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePractitioner(@PathVariable Long id) {
        practitionerService.deletePractitioner(id);
        return ResponseEntity.ok().build();
    }
} 