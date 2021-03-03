package com.example.MIS.repos;


import com.example.MIS.domain.Doctor;
import com.example.MIS.domain.Laboratoria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LabRepo extends CrudRepository<Laboratoria, Long> {

    List<Laboratoria> findByIin(String iin);

}
