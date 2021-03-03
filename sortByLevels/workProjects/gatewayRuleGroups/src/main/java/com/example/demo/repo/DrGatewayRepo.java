package com.example.demo.repo;

import com.example.demo.model.DrGateway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DrGatewayRepo extends JpaRepository<DrGateway,Integer> {

    DrGateway findByGwId(Integer integer);
}
