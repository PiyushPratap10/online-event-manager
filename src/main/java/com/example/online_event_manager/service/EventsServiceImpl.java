package com.example.online_event_manager.service;

import com.example.online_event_manager.dao.EventsDao;
import com.example.online_event_manager.entity.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsServiceImpl implements EventsService{
    private EventsDao eventsDao;

    @Autowired
    public EventsServiceImpl(EventsDao dao){
        this.eventsDao=dao;
    }
    @Override
    public void createEvent(Events event, int adminId) {
        eventsDao.createEvent(event,adminId);
    }

    @Override
    public List<Events> getAllEvents() {
        return eventsDao.getAllEvents();
    }

    @Override
    public Events getEventById(int eventId) {
        return eventsDao.getEventById(eventId);
    }
    @Override
    public void updateEvent(Events event, int adminId) {
        eventsDao.updateEvent(event,adminId);
    }

    @Override
    public void deleteEvent(int eventId, int adminId) {
        eventsDao.deleteEvent(eventId,adminId);
    }
}
