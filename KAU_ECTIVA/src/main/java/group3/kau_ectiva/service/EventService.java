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
import java.util.ArrayList;
import java.util.List;

public class EventService {
    private List<Event> events = new ArrayList<>();

    public EventService() {

    }

    public void addEvent(Event event) {
        events.add(event);
    }
    
    public Event findById(String eventId) {
        for (Event e : events) {
            if (e.getEventId().equals(eventId)) {
                return e;
            }
        }
        return null;
    }

    public List<Event> getAllEvents() {
        return events;
    }
    
    
}



