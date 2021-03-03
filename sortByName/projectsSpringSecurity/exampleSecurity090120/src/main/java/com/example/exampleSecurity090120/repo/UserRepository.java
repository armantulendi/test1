package com.example.exampleSecurity090120.repo;

import com.example.exampleSecurity090120.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
