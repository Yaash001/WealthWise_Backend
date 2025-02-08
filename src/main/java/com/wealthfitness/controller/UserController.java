package com.wealthfitness.controller;

import com.wealthfitness.model.User;
import com.wealthfitness.service.UserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;    //to access service class

    @PostMapping("/Usersignup")//sending object to userservice class to save
    public User registerUser(@RequestBody User user) {  
        return userService.registerUser(user);      
    }

    @GetMapping("/email/{email}")//geting object from userserver class hving same email
    public Optional<User> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }
}
