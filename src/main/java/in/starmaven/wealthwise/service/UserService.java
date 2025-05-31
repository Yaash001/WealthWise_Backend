package in.starmaven.wealthwise.service;

import in.starmaven.wealthwise.entity.User;

import java.util.Optional;

public interface UserService {
    User registerUser(User user);
    Optional<User> getUserByEmail(String email);
}
