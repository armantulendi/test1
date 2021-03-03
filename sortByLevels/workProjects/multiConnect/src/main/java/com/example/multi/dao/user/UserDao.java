package com.example.multi.dao.user;

import com.example.multi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserDao extends JpaRepository<User,Integer> {
}
