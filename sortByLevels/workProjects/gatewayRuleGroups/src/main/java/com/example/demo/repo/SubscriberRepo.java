package com.example.demo.repo;

import com.example.demo.model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface SubscriberRepo extends CrudRepository<Subscriber,Integer> {
    @Override
    Optional<Subscriber> findById(Integer id);

    Iterable<Subscriber> getAllByUsername(String filter);

    Subscriber findByUsername(String username);


}
