package com.devglan.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.devglan.model.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<UserDetails, Long> {


	UserDetails findByEmail(String email);

	@Override
	Optional<UserDetails> findById(Long aLong);
}
