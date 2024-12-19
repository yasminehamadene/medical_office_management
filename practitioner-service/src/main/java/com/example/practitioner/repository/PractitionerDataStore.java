package com.example.practitioner.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

import com.example.practitioner.model.Practitioner;

@Component
public class PractitionerDataStore {
    private final List<Practitioner> practitioners = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    public List<Practitioner> findAll() {
        return new ArrayList<>(practitioners);
    }

    public Practitioner findById(Long id) {
        return practitioners.stream()
                .filter(practitioner -> practitioner.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Practitioner save(Practitioner practitioner) {
        if (practitioner.getId() == null) {
            practitioner.setId(idCounter.incrementAndGet());
            practitioners.add(practitioner);
        } else {
            deleteById(practitioner.getId());
            practitioners.add(practitioner);
        }
        return practitioner;
    }

    public void deleteById(Long id) {
        practitioners.removeIf(practitioner -> practitioner.getId().equals(id));
    }
} 