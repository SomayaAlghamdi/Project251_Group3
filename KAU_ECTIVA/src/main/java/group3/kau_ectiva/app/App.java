/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group3.kau_ectiva.app;
import group3.kau_ectiva.model.Event;
import group3.kau_ectiva.model.Student;
import group3.kau_ectiva.service.EventService;
import group3.kau_ectiva.service.RegistrationService;
import group3.kau_ectiva.service.ReportService;
import group3.kau_ectiva.service.StudentService;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author somya
 */
public class App {
     public static void main(String[] args) {
        //Preparing core services
        EventService eventService = new EventService();
        RegistrationService registrationService = new RegistrationService(eventService);
        StudentService studentService = new StudentService();

        // We add ready-made trial students to the system
        studentService.addStudent(new Student("S1", "Somaya Alghamdi", "somaya@stu.kau.edu.sa"));
        studentService.addStudent(new Student("S2", "Jana Bawaked", "Jana@stu.kau.edu.sa"));
        studentService.addStudent(new Student("S3", "Raghad Ghamri", "Raghad@stu.kau.edu.sa"));
        studentService.addStudent(new Student("S4", "Wjood Alammari ", "Wjood@stu.kau.edu.sa"));
        studentService.addStudent(new Student("S5", "Atheer AlSulami", "Atheer@stu.kau.edu.sa"));
        studentService.addStudent(new Student("S6", "Lama Alghamdi", "Lama@stu.kau.edu.sa"));

        ReportService reportService = new ReportService(eventService, registrationService, studentService);

        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to KAU-ECTIVA System");
        System.out.println("Sample students you can use for testing:");
        System.out.println("S1 - Somaya Alghamdi");
        System.out.println("S2 - Jana Bawaked");
        System.out.println("S3 - Raghad Ghamri");
        System.out.println("S4 - Wjood Alammari");
        System.out.println("S5 - Atheer AlSulami");
        System.out.println("S6 - Lama Alghamdi");

        do {
            System.out.println("\n=== KAU-ECTIVA System ===");
            System.out.println("1. Browse/Search events");
            System.out.println("2. Register for event");
            System.out.println("3. Add new event");
            System.out.println("4. Generate report");
            System.out.println("0. Exit");
            System.out.print("Enter your choice : (1 , 2 , 3 , 4 or 0) ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                     // Browse / Search
                    System.out.print("Enter keyword (leave empty to show all events): ");
                    String keyword = scanner.nextLine();
                    List<Event> results = eventService.searchEvents(keyword);
                    if (results.isEmpty()) {
                        System.out.println("No events found.");
                    } else {
                        System.out.println("Found events:");
                        
                        for (Event e : results) {
                       System.out.println("---------------------------");
                       System.out.println(e);
                      
                       }
                    
                    }
                    break;
                    

                case 2:
                    // Register for event
                    System.out.print("Enter student ID (e.g., S1, S2, S3 , S4, S5, S6 ): ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter event ID: ");
                    String eventId = scanner.nextLine();
                    registrationService.registerStudent(studentId, eventId);
                    break;

                case 3:
                    //Add new event
                    String newId = eventService.generateEventId();
                    System.out.println("Event ID generated automatically: " + newId);
                    System.out.print("Enter event name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Enter date (e.g., 2025-12-01): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter time (e.g., 10:00): ");
                    String time = scanner.nextLine();
                    System.out.print("Enter location: ");
                    String loc = scanner.nextLine();
                    System.out.print("Enter capacity: ");
                    int cap = scanner.nextInt();
                    scanner.nextLine(); 

                    Event newEvent = new Event(newId, newName, desc, date, time, loc, cap, cap);
                    eventService.addEvent(newEvent);
                    System.out.println("Event added successfully.");
                    break;


                case 4:
                    //View list of current events
                    List<Event> allEvents = eventService.getAllEvents();

                    if (allEvents.isEmpty()) {
                        System.out.println("No events available.");
                        break;
                    }
                    System.out.println("\n=== Available Events ===");
                    for (Event e : allEvents) {
                        System.out.println(e.getEventId() + " - " + e.getName());
                    }
                    System.out.println("========================");
                    // Generate report
                    System.out.print("Enter event ID to generate report: ");
                    String repEventId = scanner.nextLine();
                    reportService.generateReport(repEventId);
                    break;

                case 0:
                    System.out.println("Bye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }
}
