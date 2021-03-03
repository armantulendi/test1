package com.example.MIS.repos;


import com.example.MIS.domain.Registration;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegistrationRepo extends CrudRepository<Registration, Long> {

    List<Registration> findByIin(String iin);

}
