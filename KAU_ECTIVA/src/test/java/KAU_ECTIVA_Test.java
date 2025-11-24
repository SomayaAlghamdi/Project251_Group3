/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author somya
 */
import group3.kau_ectiva.model.Event;
import group3.kau_ectiva.model.Registration;
import group3.kau_ectiva.model.Student;
import group3.kau_ectiva.service.EventService;
import group3.kau_ectiva.service.RegistrationService;
import group3.kau_ectiva.service.ReportService;
import group3.kau_ectiva.service.StudentService;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Before;
import org.junit.Test;

public class KAU_ECTIVA_Test {
    private EventService eventService;
    private RegistrationService registrationService;
    private StudentService studentService;
    private ReportService reportService;
    
    @Before
    public void setUp() {
        eventService = new EventService();
        studentService = new StudentService();
        registrationService = new RegistrationService(eventService, studentService);
        reportService = new ReportService(eventService, registrationService, studentService);

        // Add static test data
        Event e1 = new Event(
        "E1",
        "Scientific Societies Innovation Challenge",
        "Individual competition for KAU students to present impactful ideas",
        "2025-11-11",
        "10:00",
        "King Faisal Conference Center",
        3,      // capacity
        3       // available seats
        );

        Event e2 = new Event(
        "E2",
        "Athar Hackathon",
        "Innovation & entrepreneurship hackathon for university students",
        "2025-10-21",
        "09:00",
        "KAU Innovation & Entrepreneurship Center",
        2,      // capacity
        2       // available seats
        );
        eventService.addEvent(e1);
        eventService.addEvent(e2);

        studentService.addStudent(new Student("S1", "Raghad", "Raghad@stu.kau.edu.sa"));
        studentService.addStudent(new Student("S2", "Jana", "jana@stu.kau.edu.sa"));
        studentService.addStudent(new Student("S3", "Wjood", "wjood@stu.kau.edu.sa"));
    }
    // -------------------------------------------------------------
    // 1) Unit Test — Add Event
    // -------------------------------------------------------------
    @Test
    public void testAddEvent_successfullyAdded() {
        Event newEvent = new Event("E3", "Innovation Hackathon", "University-wide competition for creative ideas",
                "2025-11-30", "09:00", "KAU Conference Center", 5, 5);
        eventService.addEvent(newEvent);
        Event result = eventService.findById("E3");

        assertNotNull("Event should be added", result);//Is the event happening now?
        assertEquals("Event name should match", "Innovation Hackathon", result.getName());//Is the data correct?
        assertEquals("Available seats should equal capacity", 5, result.getAvailableSeats());//Does the capacity equal the number of available seats?
    }
    

}
