package com.example.demo.repo;

import com.example.demo.model.DrGroups;
import com.example.demo.model.DrRules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DrRulesRepo extends JpaRepository<DrRules,Integer> {

    DrRules findByRuleId(Integer integer);
}
