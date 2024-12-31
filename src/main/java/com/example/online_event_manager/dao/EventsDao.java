package com.example.online_event_manager.dao;

import com.example.online_event_manager.entity.Events;

import java.util.List;

public interface EventsDao {
    void createEvent(Events event, int adminId);
    List<Events> getAllEvents();
    Events getEventById(int eventId);
    void updateEvent(Events event);
    void deleteEvent(int eventId);
}
