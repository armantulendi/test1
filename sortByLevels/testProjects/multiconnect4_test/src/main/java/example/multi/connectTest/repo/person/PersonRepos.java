package example.multi.connectTest.repo.person;


import example.multi.connectTest.model.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PersonRepos extends CrudRepository<Person,Long> {
    @Autowired
    Optional<Person> findById(Long id);
}
