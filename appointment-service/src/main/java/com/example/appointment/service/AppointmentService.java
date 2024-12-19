package com.example.appointment.service;

import com.example.appointment.model.Appointment;
import com.example.appointment.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    public List<Appointment> getAppointmentsByPatient(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    public List<Appointment> getAppointmentsByPractitioner(Long practitionerId) {
        return appointmentRepository.findByPractitionerId(practitionerId);
    }

    public List<Appointment> getAppointmentsByDateRange(LocalDateTime start, LocalDateTime end) {
        return appointmentRepository.findByDateTimeBetween(start, end);
    }

    public Appointment createAppointment(Appointment appointment) {
        // Add validation logic here
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Long id, Appointment appointment) {
        Appointment existingAppointment = getAppointmentById(id);
        appointment.setId(existingAppointment.getId());
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
} 