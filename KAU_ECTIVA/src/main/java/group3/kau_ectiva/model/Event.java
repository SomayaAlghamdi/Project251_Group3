/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group3.kau_ectiva.model;

/**
 *
 * @author somya
 */
public class Event {
    private String eventId;
    private String name;
    private String description;
    private String date;
    private String time;
    private String location;
    private int capacity;
    private int availableSeats;
    
    public Event(String eventId, String name, String description,String date, String time, 
    String location, int capacity, int availableSeats) {
        this.eventId = eventId;
        this.name = name;
        this.description = description;
        this.date = date;
        this.time = time;
        this.location = location;
        this.capacity = capacity;
        this.availableSeats = availableSeats;
    }
    
}
