package com.example.online_event_manager.dao;

import com.example.online_event_manager.entity.Events;
import com.example.online_event_manager.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class EventsDaoImpl implements EventsDao{

    private EntityManager entityManager;

    @Autowired
    public EventsDaoImpl(EntityManager manager){
        this.entityManager=manager;
    }
    @Override
    public void createEvent(Events event, int adminId) {
        Users user=entityManager.find(Users.class,adminId);
        if(user==null || !user.getRole().equalsIgnoreCase("ADMIN")){
            throw new IllegalArgumentException("Only ADMIN users can create events.");
        }
        entityManager.persist(event);
    }

    @Override
    public List<Events> getAllEvents() {
        String query="SELECT e FROM Events e";
        return entityManager.createQuery(query,Events.class).getResultList();
    }

    @Override
    public Events getEventById(int eventId) {
        return entityManager.find(Events.class,eventId);
    }

    @Override
    public void updateEvent(Events event) {
        entityManager.merge(event);
    }

    @Override
    public void deleteEvent(int eventId) {
        Events event=entityManager.find(Events.class,eventId);
        if(event != null){
            entityManager.remove(event);
        }else{
            throw new IllegalArgumentException("Event not found with ID: " + eventId);
        }
    }
}
