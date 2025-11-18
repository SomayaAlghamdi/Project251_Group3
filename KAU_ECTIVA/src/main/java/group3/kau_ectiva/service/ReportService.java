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
import group3.kau_ectiva.model.Student;
import java.util.List;
public class ReportService {

    private EventService eventService;
    private RegistrationService registrationService;
    private StudentService studentService;

    public ReportService(EventService eventService,
                         RegistrationService registrationService,
                         StudentService studentService) {
        this.eventService = eventService;
        this.registrationService = registrationService;
        this.studentService = studentService;
    }

    public void generateReport(String eventId) {
        Event event = eventService.findById(eventId);
        if (event == null) {
            System.out.println("Event not found.");
            return;
        }

        List<Registration> regs =
                registrationService.getRegistrationsForEvent(eventId);

        System.out.println("=== Report for Event: " + event.getName() + " ===");
        System.out.println("Event ID: " + event.getEventId());
        System.out.println("Total capacity: " + event.getCapacity());
        System.out.println("Registered students: " + regs.size());
        System.out.println("Available seats: " + event.getAvailableSeats());

        if (regs.isEmpty()) {
            System.out.println("No students registered for this event.");
        } else {
            System.out.println("List of registered students:");
            for (Registration r : regs) {
                Student st = studentService.findById(r.getStudentId());
                if (st != null) {
                    System.out.println(" - " + st.getName() + " (" + st.getStudentId() + ")");
                }
            }
        }
    }
   
}
