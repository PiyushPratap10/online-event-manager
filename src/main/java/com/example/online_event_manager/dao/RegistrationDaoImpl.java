package com.example.online_event_manager.dao;

import com.example.online_event_manager.entity.Events;
import com.example.online_event_manager.entity.Registration;
import com.example.online_event_manager.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class RegistrationDaoImpl implements RegistrationDao {

    private final EntityManager entityManager;

    @Autowired
    public RegistrationDaoImpl(EntityManager manager){
        this.entityManager=manager;
    }
    @Override
    public void registerUserForEvent(int userId, int eventId) {
        Users user=entityManager.find(Users.class,userId);
        Events event=entityManager.find(Events.class,eventId);
        if (user==null){
            throw new IllegalArgumentException("User not found with ID: "+userId);
        }
        if (event==null){
            throw new IllegalArgumentException("Event not found with ID: "+eventId);
        }
        String query="SELECT r FROM Registration r WHERE r.user.id= :userId AND r.event.id = :eventId";
        List<Registration> existingRegistrations= entityManager.createQuery(query,Registration.class)
                .setParameter("userId",userId)
                .setParameter("eventId",eventId)
                .getResultList();
        if(!existingRegistrations.isEmpty()){
            throw new IllegalArgumentException("User is already registered for this event.");
        }
        Registration reg=new Registration(user,event);
        entityManager.persist(reg);
    }

    @Override
    public List<Registration> getRegistrationsByUser(int userId) {
        String query = "SELECT r FROM Registration r WHERE r.user.id = :userId";
        return entityManager.createQuery(query, Registration.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public List<Registration> getRegistrationsByEvent(int eventId) {
        String query = "SELECT r FROM Registration r WHERE r.event.id = :eventId";
        return entityManager.createQuery(query, Registration.class)
                .setParameter("eventId", eventId)
                .getResultList();
    }

    @Override
    public void cancelRegistration(int registrationId, int userId) {
        Registration registration = entityManager.find(Registration.class, registrationId);

        if (registration == null) {
            throw new IllegalArgumentException("Registration not found with ID: " + registrationId);
        }

        if (registration.getUser().getId() != userId) {
            throw new IllegalArgumentException("User is not authorized to cancel this registration.");
        }

        entityManager.remove(registration);
    }
}
