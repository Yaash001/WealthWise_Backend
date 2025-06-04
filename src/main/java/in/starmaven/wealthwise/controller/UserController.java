package in.starmaven.wealthwise.controller;

import in.starmaven.wealthwise.entity.User;
import in.starmaven.wealthwise.service.UserService;
import in.starmaven.wealthwise.security.JwtUtil;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:5173")
// @CrossOrigin(origins = "*")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private UserService userService;    //to access service class
    private JwtUtil jwtUtil;

    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/Usersignup")//sending object to userservice class to save
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User savedUser = userService.registerUser(user);
            log.info("recive data :{}",user);
            return ResponseEntity.ok(savedUser);  // Return HTTP 200 OK with user data
        } catch (Exception e) {     //it return error message
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User registration failed: " + e.getMessage());
        }
    }

    @GetMapping("/profile")// Extract email from token
        public ResponseEntity<?> getUserProfile(@RequestHeader("Authorization") String token) {
        
            String email = jwtUtil.extractEmail(token.substring(7)); // Remove "Bearer " from token
            
            Optional<User> user = userService.getUserByEmail(email);
            
            if (user.isPresent()) {
                return ResponseEntity.ok(user.get());
            } else {
                return ResponseEntity.status(404).body("User not found");
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