package in.starmaven.wealthwise.service.impl;

import in.starmaven.wealthwise.entity.User;
import in.starmaven.wealthwise.entity.Family;
import in.starmaven.wealthwise.repository.UserRepository;
import in.starmaven.wealthwise.service.UserService;
import in.starmaven.wealthwise.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FamilyService familyService;

    @Override
    public User registerUser(User user) {
        Family savedFamily = null;
        if (user.getFamily() != null) {
            savedFamily = familyService.save(user.getFamily());
        }
        user.setFamily(savedFamily);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
