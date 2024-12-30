package com.example.online_event_manager.service;

import com.example.online_event_manager.dao.UsersDao;
import com.example.online_event_manager.entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UsersDao usersDao;

    @Autowired
    public UserServiceImpl(UsersDao dao){
        this.usersDao=dao;
    }
    @Override
    public List<Users> findAll() {
        return usersDao.findAll();
    }

    @Override
    public Users findById(int theId) {
        return usersDao.findById(theId);
    }

    @Override
    @Transactional
    public Users save(Users theUser) {
        return usersDao.save(theUser);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        usersDao.deleteById(theId);
    }

    @Override
    public Users findByEmail(String email) {
        return findByEmail(email);
    }

    @Override
    public List<Users> findByRole(String role) {
        return usersDao.findByRole(role);
    }
}
