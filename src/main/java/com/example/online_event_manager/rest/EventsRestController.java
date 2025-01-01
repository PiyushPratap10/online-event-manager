package com.example.online_event_manager.rest;

import com.example.online_event_manager.entity.Events;
import com.example.online_event_manager.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events/")
public class EventsRestController {
    private EventsService eventsService;

    @Autowired
    public EventsRestController(EventsService service){
        this.eventsService=service;
    }

    @GetMapping()
    public List<Events> getAllEvents(){
        return eventsService.getAllEvents();
    }

    @PostMapping("/{adminId}")
    public void createEvent(@RequestBody Events event,@PathVariable int adminId){
        event.setId(0);
        eventsService.createEvent(event,adminId);
    }
    @GetMapping("/{id}")
    public Events getEventById(@PathVariable int id){
        Events event=eventsService.getEventById(id);
        if(event==null){
            throw new RuntimeException("Event id not found - "+id);
        }
        return event;
    }
    @PutMapping("/{id}/{eid}")
    public void updateEvent(@RequestBody Events event,@PathVariable int id,@PathVariable int eid){
        event.setId(eid);
        eventsService.updateEvent(event,id);
    }
    @DeleteMapping("/{id}/{eid}")
    public void deleteEvent(@PathVariable int eid,@PathVariable int id){
        eventsService.deleteEvent(eid,id);
    }
}
