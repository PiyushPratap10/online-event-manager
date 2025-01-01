package com.example.online_event_manager.service;

import com.example.online_event_manager.entity.Events;

import java.util.List;

public interface EventsService {
    void createEvent(Events event, int adminId);
    List<Events> getAllEvents();
    Events getEventById(int eventId);

    void updateEvent(Events event, int adminId);

    void deleteEvent(int eventId, int adminId);
}
