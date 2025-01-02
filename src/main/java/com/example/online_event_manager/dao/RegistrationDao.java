package com.example.online_event_manager.dao;

import com.example.online_event_manager.entity.Registration;

import java.util.List;

public interface RegistrationDao {
    void registerUserForEvent(int userId, int eventId);
    List<Registration> getRegistrationsByUser(int userId);
    List<Registration> getRegistrationsByEvent(int eventId);
    void cancelRegistration(int registrationId, int userId);
}
