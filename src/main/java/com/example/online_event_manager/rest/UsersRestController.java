package com.example.online_event_manager.rest;

import com.example.online_event_manager.entity.Users;
import com.example.online_event_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UsersRestController {
    private final UserService userService;

    @Autowired
    public UsersRestController(UserService service){
        this.userService=service;
    }

    @GetMapping
    public List<Users> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Users findById(@PathVariable int id){
        Users user = userService.findById(id);
        if(user ==null){
            throw new RuntimeException("User id not found - "+id);
        }
        return user;
    }

    @PostMapping
    public Users addUser(@RequestBody Users user){
        user.setId(0);
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public Users updateUser(@PathVariable int id,@RequestBody Users user){
        Users existingUser= userService.findById(id);
        if (existingUser==null){
            throw new RuntimeException("User id not found - "+id);
        }
        user.setId(id);
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        Users user = userService.findById(id);
        if(user==null){
            throw new RuntimeException("User id not found - " + id);
        }
        userService.deleteById(id);
        return "Deleted user id - " + id;
    }

    @GetMapping("/email/{email}")
    public Users findByEmail(@PathVariable String email){
        Users user = userService.findByEmail(email);
        if(user ==null){
            throw new RuntimeException("User not found with email - " + email);
        }
        return user;
    }

    @GetMapping("/role/{role}")
    public List<Users> findByRole(@PathVariable String role){
        return userService.findByRole(role);
    }
}
