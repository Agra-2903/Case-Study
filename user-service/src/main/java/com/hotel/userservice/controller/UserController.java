package com.hotel.userservice.controller;

import com.hotel.userservice.model.UserRole;
import com.hotel.userservice.model.User;
import com.hotel.userservice.service.AuthService;
import com.hotel.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

//    @PostMapping("/login")
//    public String login(@RequestParam String username, @RequestParam String password) {
//        authService.authenticateUser(username, password);
//        return "Login successful";
//    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }
}
