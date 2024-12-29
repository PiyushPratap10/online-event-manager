package com.example.online_event_manager.dao;

import com.example.online_event_manager.entity.Users;

import java.util.List;

public interface UsersDao {
    List<Users> findAll();
    Users findById(int theId);
    Users save(Users theUser);
    void deleteById(int theId);
    Users findByEmail(String email);
    List<Users> findByRole(String role);
}
