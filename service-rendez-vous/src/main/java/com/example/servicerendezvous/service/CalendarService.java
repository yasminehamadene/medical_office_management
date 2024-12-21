package com.example.servicerendezvous.service;

import java.io.IOException;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.servicerendezvous.exception.CalendarServiceException;
import com.example.servicerendezvous.model.RendezVous;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;

import io.github.resilience4j.retry.annotation.Retry;

@Service
public class CalendarService {
    
    private final Calendar calendarService;
    
    public CalendarService() throws Exception {
        this.calendarService = new Calendar.Builder(
            GoogleNetHttpTransport.newTrustedTransport(),
            JacksonFactory.getDefaultInstance(),
            null)
            .setApplicationName("Service-RendezVous")
            .build();
    }
    
    @Retry(name = "calendarApi")
    public Event createCalendarEvent(RendezVous rendezVous) {
        try {
            Date date = Date.from(rendezVous.getDate().atZone(ZoneId.systemDefault()).toInstant());
            Event event = new Event()
                .setSummary("RDV: " + rendezVous.getPatientId())
                .setDescription(rendezVous.getDescription())
                .setStart(new EventDateTime().setDateTime(new DateTime(date)))
                .setEnd(new EventDateTime().setDateTime(new DateTime(Date.from(rendezVous.getDate().plusHours(1).atZone(ZoneId.systemDefault()).toInstant()))));
                
            return calendarService.events()
                .insert("primary", event)
                .execute();
        } catch (IOException e) {
            throw new CalendarServiceException("Erreur lors de la création de l'événement", e);
        }
    }
} 