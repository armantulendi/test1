package com.multiconnect.user.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;


public interface UserDao extends CrudRepository {
    UserDetails findByEmail(String email);

}