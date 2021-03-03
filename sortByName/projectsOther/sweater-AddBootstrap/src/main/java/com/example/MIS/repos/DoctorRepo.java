package com.example.MIS.repos;


import com.example.MIS.domain.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DoctorRepo extends CrudRepository<Doctor, Long> {

    List<Doctor> findByIin(String iin);

}
