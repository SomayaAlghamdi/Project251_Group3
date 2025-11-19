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
                    

                case 2:

                case 3:
                    

                case 4:
     

                case 0:
                    System.out.println("Bye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }
}
