/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group3.kau_ectiva.service;
import group3.kau_ectiva.model.Student;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Wjood
 */
public class StudentService {
     private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }
    
    
     public Student findById(String studentId) {
        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(studentId)) {
                return s;
            }
        }
        return null; 
    }
     
      public List<Student> getAllStudents() {
        return students;
    }
    
   
}
