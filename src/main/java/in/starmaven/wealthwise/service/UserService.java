package in.starmaven.wealthwise.service;

import in.starmaven.wealthwise.entity.User;
import in.starmaven.wealthwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

   @Autowired
   private UserRepository userRepository;      //to access userRepository class

   //saves user in database
   public User registerUser(User user) {
       return userRepository.save(user);
   }

   //fetch by email
   public Optional<User> getUserByEmail(String email) {
       return userRepository.findByEmail(email);
   }
}
