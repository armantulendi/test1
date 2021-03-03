package com.prim.dao.user;

import com.prim.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User,Long> {
    @Override
    Iterable<User> findAll();
}
