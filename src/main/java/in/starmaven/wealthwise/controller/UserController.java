package in.starmaven.wealthwise.controller;

import in.starmaven.wealthwise.entity.User;
import in.starmaven.wealthwise.service.UserService;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")

public class UserController {
Logger log = LoggerFactory.getLogger(UserController.class);
   @Autowired
   private UserService userService;    //to access service class
@PostMapping("/Usersignup")
public ResponseEntity<?> registerUser(@RequestBody User user) {
    try {
        User savedUser = userService.registerUser(user); // saving to DB
        log.info("Saved User: {}", savedUser);
        return ResponseEntity.ok(savedUser);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("User registration failed: " + e.getMessage());
    }
}


   @GetMapping("/email/{email}")//geting object from userserver class hving same email
   public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
       Optional<User> user = userService.getUserByEmail(email);
       if (user.isPresent()) {
           return ResponseEntity.ok(user.get());  // Return HTTP 200 OK with user data
       } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with email: " + email);
       }
   }
}