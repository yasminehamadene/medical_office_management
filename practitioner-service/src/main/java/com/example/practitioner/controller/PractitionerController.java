package com.example.practitioner.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.practitioner.model.Practitioner;
import com.example.practitioner.service.PractitionerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/practitioners")
@RequiredArgsConstructor
@Tag(name = "Practitioner", description = "API de gestion des praticiens")
public class PractitionerController {

    private final PractitionerService practitionerService;

    @Operation(summary = "Récupérer tous les praticiens", description = "Retourne la liste de tous les praticiens enregistrés")
    @ApiResponse(responseCode = "200", description = "Liste des praticiens récupérée avec succès")
    @GetMapping
    public List<Practitioner> getAllPractitioners() {
        Practitioner practitioner1 = new Practitioner();
        practitioner1.setId(1L);
        practitioner1.setFirstName("Jean ");
        practitioner1.setLastName("Leschi");
        practitioner1.setDateOfBirth(LocalDate.of(1970, 4, 2));
        practitioner1.setEmail("Jean@email.com");
        practitioner1.setPhone("0123456789");
        practitioner1.setAddress("123 Rue de Paris");

        Practitioner practitioner2 = new Practitioner();
        practitioner2.setId(2L);
        practitioner2.setFirstName("Paul");
        practitioner2.setLastName("Jacky");
        practitioner2.setDateOfBirth(LocalDate.of(1985, 5, 15));
        practitioner2.setEmail("Jacky@email.com");
        practitioner2.setPhone("0987654321");
        practitioner2.setAddress("456 Avenue des Champs");

        return Arrays.asList(practitioner1, practitioner2);
    }

    @Operation(summary = "Récupérer un praticien par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Praticien trouvé"),
            @ApiResponse(responseCode = "404", description = "Praticien non trouvé")
    })
    @GetMapping("/{id}")
    public Practitioner getPractitionerById(@PathVariable Long id) {
        Practitioner practitioner = new Practitioner();
        practitioner.setId(id);
        practitioner.setFirstName("Nom Prénom");
        practitioner.setLastName("Inconnu");
        practitioner.setDateOfBirth(LocalDate.of(2000, 1, 1));
        practitioner.setEmail("email@inconnu.com");
        practitioner.setPhone("0000000000");
        practitioner.setAddress("Adresse inconnue");

        return practitioner;
    }

    @Operation(summary = "Créer un nouveau praticien", description = "Ajoute un nouveau praticien à la liste")
    @ApiResponse(responseCode = "200", description = "Praticien créé avec succès")
    @PostMapping
    public Practitioner createPractitioner(@RequestBody Practitioner practitioner) {
        practitioner.setId(3L);
        return practitioner;
    }

    @Operation(summary = "Mettre à jour un praticien existant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Praticien mis à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Praticien non trouvé")
    })
    @PutMapping("/{id}")
    public Practitioner updatePractitioner(@PathVariable Long id, @RequestBody Practitioner practitioner) {
        practitioner.setId(id);
        return practitioner;
    }

    @Operation(summary = "Supprimer un praticien")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Praticien supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Praticien non trouvé")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePractitioner(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }
}
