/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group3.kau_ectiva.service;

/**
 *
 * @author somya
 */
import group3.kau_ectiva.model.Event;
import group3.kau_ectiva.model.Registration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegistrationService {
    private List<Registration> registrations = new ArrayList<>();
    private EventService eventService;

    public RegistrationService(EventService eventService) {
        this.eventService = eventService;
    }

    public boolean registerStudent(String studentId, String eventId) {
        Event event = eventService.findById(eventId);
        if (event == null) {
            System.out.println("Event not found.");
            return false;
        }

        // check duplicate
        for (Registration r : registrations) {
            if (r.getStudentId().equals(studentId) &&
                r.getEventId().equals(eventId)) {
                System.out.println("Student already registered.");
                return false;
            }
        }

        // check capacity
        if (event.getAvailableSeats() <= 0) {
            System.out.println("Event is full.");
            return false;
        }

        // create registration
        String today = LocalDate.now().toString();
        Registration reg = new Registration(studentId, eventId, today);
        registrations.add(reg);

        // update seats
        event.setAvailableSeats(event.getAvailableSeats() - 1);

        System.out.println("Registration completed.");
        return true;
    }

    public List<Registration> getRegistrationsForEvent(String eventId) {
        List<Registration> result = new ArrayList<>();
        for (Registration r : registrations) {
            if (r.getEventId().equals(eventId)) {
                result.add(r);
            }
        }
        return result;
    }
    
}
