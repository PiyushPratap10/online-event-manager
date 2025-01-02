package com.example.online_event_manager.service;

import com.example.online_event_manager.dao.RegistrationDao;
import com.example.online_event_manager.entity.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationDao registrationDao;

    @Autowired
    public RegistrationServiceImpl(RegistrationDao registrationDao) {
        this.registrationDao = registrationDao;
    }

    @Override
    public void registerUserForEvent(int userId, int eventId) {
        registrationDao.registerUserForEvent(userId, eventId);
    }

    @Override
    public List<Registration> getRegistrationsByUser(int userId) {
        return registrationDao.getRegistrationsByUser(userId);
    }

    @Override
    public List<Registration> getRegistrationsByEvent(int eventId) {
        return registrationDao.getRegistrationsByEvent(eventId);
    }

    @Override
    public void cancelRegistration(int registrationId, int userId) {
        registrationDao.cancelRegistration(registrationId, userId);
    }
}
