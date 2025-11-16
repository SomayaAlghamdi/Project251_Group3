/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group3.kau_ectiva.model;

/**
 *
 * @author somya
 */
public class Registration {
    private String studentId;
    private String eventId;
    private String registrationDate;
    
    public Registration(String studentId, String eventId, String registrationDate) {
        this.studentId = studentId;
        this.eventId = eventId;
        this.registrationDate = registrationDate;
    }
    public String getStudentId() { 
        return studentId; 
    }
    
    public String getEventId() {
        return eventId; 
    }
    public String getRegistrationDate() { 
        return registrationDate; 
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
    
    
    
    
}
