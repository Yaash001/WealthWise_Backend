package in.starmaven.wealthwise.service;

import in.starmaven.wealthwise.entity.User;
import in.starmaven.wealthwise.repository.UserRepository;
import in.starmaven.wealthwise.entity.Family;
import in.starmaven.wealthwise.repository.FamilyRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final FamilyRepository familyRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,FamilyRepository familyRepository) {
        this.userRepository = userRepository;
        this.familyRepository=familyRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User registerUser(User user) {
        Optional<Family> familyOptional = familyRepository.findByName(user.getFamily_name());
        if (familyOptional.isPresent()) {
            user.setFamily(familyOptional.get());
        } else {
            // Handle the case where the family is not found
            throw new RuntimeException("Family not found: " + user.getFamily_name());
        }
        
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email is already exist try other.....");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    //fetch by email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
