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
    private int eventCounter= 1;

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
    
    // Core Function: Search events by keyword
    public List<Event> searchEvents(String keyword) {
        List<Event> result = new ArrayList<>();
            if (keyword == null || keyword.isEmpty()) {
            // If the user didn't write anything, reset all the events
                  return new ArrayList<>(events);
           }
        String lowerKeyword = keyword.toLowerCase();
        for (Event e : events) {
            String name = e.getName().toLowerCase();
            String description = e.getDescription().toLowerCase() ;
            String location = e.getLocation().toLowerCase();
            String date = e.getDate().toLowerCase();

            if (name.contains(lowerKeyword)|| description.contains(lowerKeyword)
                || location.contains(lowerKeyword)|| date.contains(lowerKeyword)){

                result.add(e);}
        }

          return result;
        }
    
    public String generateEventId() {
        String id = "E" + eventCounter;
        eventCounter++;
        return id;
    }

}



