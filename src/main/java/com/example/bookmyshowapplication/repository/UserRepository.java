package com.example.bookmyshowapplication.repository;

import com.example.bookmyshowapplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Get the user in DB (based on the email)
    Optional<User> findByEmail(String email);

}
