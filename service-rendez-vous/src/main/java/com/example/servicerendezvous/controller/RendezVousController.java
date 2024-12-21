package com.example.servicerendezvous.controller;

import com.example.servicerendezvous.model.RendezVous;
import com.example.servicerendezvous.service.RendezVousService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Rendez-vous", description = "API de gestion des rendez-vous")
@RestController
@RequestMapping("/api/rendez-vous")
public class RendezVousController {

    @Autowired
    private RendezVousService rendezVousService;

    @Operation(summary = "Créer un nouveau rendez-vous")
    @PostMapping
    public RendezVous createRendezVous(@RequestBody RendezVous rendezVous) {
        return rendezVousService.saveRendezVous(rendezVous);
    }

    @Operation(summary = "Obtenir un rendez-vous par son ID")
    @GetMapping("/{id}")
    public ResponseEntity<RendezVous> getRendezVousById(@PathVariable Long id) {
        return rendezVousService.getRendezVousById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RendezVous> updateRendezVous(@PathVariable Long id, @RequestBody RendezVous rendezVous) {
        return rendezVousService.getRendezVousById(id)
                .map(existingRendezVous -> {
                    rendezVous.setId(id);
                    return ResponseEntity.ok(rendezVousService.saveRendezVous(rendezVous));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRendezVous(@PathVariable Long id) {
        if (rendezVousService.getRendezVousById(id).isPresent()) {
            rendezVousService.deleteRendezVous(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
} 