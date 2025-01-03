package com.example.online_event_manager.rest;

import com.example.online_event_manager.entity.Registration;
import com.example.online_event_manager.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registrations")
@CrossOrigin(origins = "*")
public class RegistrationRestController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationRestController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public String registerUserForEvent(@RequestParam int userId, @RequestParam int eventId) {
        registrationService.registerUserForEvent(userId, eventId);
        return "User with ID " + userId + " successfully registered for event with ID " + eventId + ".";
    }

    @GetMapping("/user/{userId}")
    public List<Registration> getRegistrationsByUser(@PathVariable int userId) {
        return registrationService.getRegistrationsByUser(userId);
    }

    @GetMapping("/event/{eventId}")
    public List<Registration> getRegistrationsByEvent(@PathVariable int eventId) {
        return registrationService.getRegistrationsByEvent(eventId);
    }

    @DeleteMapping("/{registrationId}/cancel")
    public String cancelRegistration(@PathVariable int registrationId, @RequestParam int userId) {
        registrationService.cancelRegistration(registrationId, userId);
        return "Registration with ID " + registrationId + " has been successfully canceled for user with ID " + userId + ".";
    }
}
