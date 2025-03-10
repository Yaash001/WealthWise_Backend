package in.starmaven.wealthwise.controller;

import in.starmaven.wealthwise.entity.User;
import in.starmaven.wealthwise.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:5173")

public class UserController {

   @Autowired
   private UserService userService;    //to access service class

   @PostMapping("/Usersignup")//sending object to userservice class to save
   public ResponseEntity<?> registerUser(@RequestBody User user) {
       try {
           User savedUser = userService.registerUser(user);
           return ResponseEntity.ok(savedUser);  // Return HTTP 200 OK with user data
       } catch (Exception e) {     //it return error message
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User registration failed: " + e.getMessage());
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