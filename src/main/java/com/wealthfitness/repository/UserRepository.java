package com.wealthfitness.repository;

import com.wealthfitness.model.User;
import org.springframework.data.jpa.repository.JpaRepository;//to do CRUD operations on user table 
import org.springframework.stereotype.Repository;
import java.util.Optional;

//long is primay kay and user is class
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);//finding by email
}
