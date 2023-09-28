package com.jamsheed.universityManagementSystem.service;

import com.jamsheed.universityManagementSystem.model.Event;
import com.jamsheed.universityManagementSystem.model.Student;
import com.jamsheed.universityManagementSystem.repo.IEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {
    @Autowired
    IEventRepo eventRepo;

    public String addEvents(List<Event> newEvents) {
        eventRepo.saveAll(newEvents);
        return newEvents.size() +" Events added";
    }

    public String updateEventById(Integer id, Event updateEvent) {
        Event existingEvent = eventRepo.findById(id).orElse(null);
        if(existingEvent != null){
            if(updateEvent.getEventId() != null)
                existingEvent.setEventId(updateEvent.getEventId());
            if(updateEvent.getEventName() != null)
                existingEvent.setEventName(updateEvent.getEventName());
            if(updateEvent.getLocation() != null)
                existingEvent.setLocation(updateEvent.getLocation());
            if(updateEvent.getDate() != null)
                existingEvent.setDate(updateEvent.getDate());
            if(updateEvent.getStartTime() != null)
                existingEvent.setStartTime(updateEvent.getStartTime());
            if(updateEvent.getEndTime() != null)
                existingEvent.setEndTime(updateEvent.getEndTime());

            eventRepo.save(existingEvent);

            return "Event Info Updated";

        }

        return "Event Not found with given ID :"+ id;
    }

    public String deleteEventById(Integer id) {
        Event existingEvent = eventRepo.findById(id).orElse(null);

        if(existingEvent != null){
            eventRepo.delete(existingEvent);
            return "Event with ID: "+id+" deleted";
        }

        return "Student Not found with given ID :"+ id;
    }

    public List<Event> getAllEventsByDate(LocalDate date) {
        return eventRepo.findByDate(date);
    }

    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }
}
