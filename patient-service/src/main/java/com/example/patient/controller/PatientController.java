package com.example.patient.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.patient.model.Patient;
import com.example.patient.service.PatientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
@Api(tags = "Patient", description = "API de gestion des patients")
public class PatientController {

    // PatientService n'est pas utilisé ici car on ne travaille pas avec la base de données
    // Le contrôleur retourne des patients fictifs
    @ApiOperation(value = "Récupérer tous les patients", notes = "Retourne la liste de tous les patients enregistrés")
    @ApiResponse(code = 200, message = "Liste des patients récupérée avec succès")
    @GetMapping
    public List<Patient> getAllPatients() {
        // Crée une liste de patients avec des attributs vides ou par défaut
        Patient patient1 = new Patient();
        patient1.setId(1L);
        patient1.setFirstName("Hamadene");
        patient1.setLastName("Yasmine");
        patient1.setDateOfBirth(LocalDate.of(2000, 4, 2));
        patient1.setEmail("yasmine@email.com");
        patient1.setPhone("0123456789");
        patient1.setAddress("123 Rue de Paris");

        Patient patient2 = new Patient();
        patient2.setId(2L);
        patient2.setFirstName("Mourad");
        patient2.setLastName("Lemoine");
        patient2.setDateOfBirth(LocalDate.of(1985, 5, 15));
        patient2.setEmail("mouradlemoine@email.com");
        patient2.setPhone("0987654321");
        patient2.setAddress("456 Avenue des Champs");

        return Arrays.asList(patient1, patient2); // Retourne une liste de patients fictifs
    }

    @ApiOperation(value = "Récupérer un patient par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Patient trouvé"),
            @ApiResponse(code = 404, message = "Patient non trouvé")
    })
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        // Retourne un patient avec les attributs vides ou par défaut
        Patient patient = new Patient();
        patient.setId(id);
        patient.setFirstName("Nom Prénom");
        patient.setLastName("Inconnu");
        patient.setDateOfBirth(LocalDate.of(2000, 1, 1));
        patient.setEmail("email@inconnu.com");
        patient.setPhone("0000000000");
        patient.setAddress("Adresse inconnue");

        return patient; // Retourne un patient fictif
    }

    @ApiOperation(value = "Créer un nouveau patient", notes = "Ajoute un nouveau patient à la liste")
    @ApiResponse(code = 200, message = "Patient créé avec succès")
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        // Crée et retourne un patient fictif (sans enregistrer dans la base)
        patient.setId(3L);
        return patient; // Retourne le patient tel quel sans modification
    }

    @ApiOperation(value = "Mettre à jour un patient existant")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Patient mis à jour avec succès"),
            @ApiResponse(code = 404, message = "Patient non trouvé")
    })
    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        // Retourne le patient mis à jour (sans modification réelle de la base)
        patient.setId(id); // Assure-toi que l'ID est mis à jour
        return patient; // Retourne un patient fictif avec l'ID mis à jour
    }

    @ApiOperation(value = "Supprimer un patient")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Patient supprimé avec succès"),
            @ApiResponse(code = 404, message = "Patient non trouvé")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        // Simule la suppression sans véritablement interagir avec la base de données
        return ResponseEntity.ok().build();
    }
}
