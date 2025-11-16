/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group3.kau_ectiva.model;
/**
 *
 * @author somya
 */
public class Student {
    private String studentId;
    private String SName;
    private String email;

    public Student(String studentId, String name, String email) {
        this.studentId = studentId;
        this.SName = name;
        this.email = email;
    }

    public void setStudentId(String studentId){ 
        this.studentId = studentId;
    }
    public void setName(String name){ 
        this.SName = name; 
    }
    public void setEmail(String email){ 
        this.email = email;
    }
    
    public String getStudentId(){ 
        return studentId; 
    }
    public String getName(){ 
        return SName; 
    }
    public String getEmail(){ 
        return email; 
    }

}
