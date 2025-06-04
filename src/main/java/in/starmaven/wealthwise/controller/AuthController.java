package in.starmaven.wealthwise.controller;

import in.starmaven.wealthwise.security.JwtUtil;
import in.starmaven.wealthwise.entity.User;
import in.starmaven.wealthwise.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthController(JwtUtil jwtUtil, UserRepository userRepository) {
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isEmpty()) {
            return ResponseEntity.status(401).body("Invalid login Credentials");
        }

        User user = userOptional.get();

        System.out.println("Raw password: " + password);
        System.out.println("Raw password after encode: " + passwordEncoder.matches(password, user.getPassword()));
        System.out.println("Encoded password from DB: " + user.getPassword());
        System.out.println("Match result: " + passwordEncoder.matches(password, user.getPassword()));

        // Check given password matches the hashed password in the db
        if (!passwordEncoder.matches(password, user.getPassword()))
        {
            return ResponseEntity.status(401).body("Invalid Password");
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("email", user.getEmail());
        claims.put("role", user.getRole());
        claims.put("family_name", user.getFamily_name());
        claims.put("contactNumber", user.getContactNumber());

        String token = jwtUtil.generateToken(email, claims);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        response.put("id", String.valueOf(user.getId()));
        response.put("email", user.getEmail());
        response.put("role", user.getRole());
        response.put("family_name", user.getFamily_name());
        response.put("contactNumber", user.getContactNumber());

        return ResponseEntity.ok(response);
    }
}