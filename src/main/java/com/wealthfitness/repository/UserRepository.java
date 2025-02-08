package com.wealthfitness.repository;

import com.wealthfitness.model.User;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

//long is primay kay and user is class
@Entity
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);//finding by email
}
