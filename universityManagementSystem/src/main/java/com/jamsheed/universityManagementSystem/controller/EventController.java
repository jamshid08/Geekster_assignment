package com.jamsheed.universityManagementSystem.controller;

import com.jamsheed.universityManagementSystem.model.Event;
import com.jamsheed.universityManagementSystem.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Validated
public class EventController {
    @Autowired
    EventService eventService;

   @PostMapping("events")
    public String addEvents(@RequestBody @Valid List<Event> newEvents){
       return eventService. addEvents(newEvents);
   }

   @PutMapping("event/id/{id}")
    public String updateEventById(@PathVariable @Valid Integer id, @RequestBody Event updateEvent){

       return eventService.updateEventById(id,updateEvent);

   }

   @DeleteMapping("event/id/{id}")
    public String deleteEventById(@PathVariable @Valid Integer id){
       return eventService.deleteEventById(id);
   }

   @GetMapping("evnts/date/{date}")
    public List<Event> getAllEventsByDate(@PathVariable @Valid LocalDate date){
       return eventService. getAllEventsByDate(date);
   }

   @GetMapping("events")
    public List<Event> getAllEvents(){
       return eventService.getAllEvents();
   }
}
