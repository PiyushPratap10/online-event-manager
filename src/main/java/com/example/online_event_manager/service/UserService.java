package com.example.online_event_manager.service;

import com.example.online_event_manager.entity.Users;

import java.util.List;

public interface UserService {
    List<Users> findAll();
    Users findById(int theId);
    Users save(Users theUser);
    void deleteById(int theId);
    Users findByEmail(String email);
    List<Users> findByRole(String role);
}
