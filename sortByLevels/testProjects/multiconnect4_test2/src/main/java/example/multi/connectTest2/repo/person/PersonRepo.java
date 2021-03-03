package example.multi.connectTest2.repo.person;

import example.multi.connectTest2.model.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PersonRepo extends CrudRepository<Person,Long> {
    @Autowired
    Optional<Person> findById(Long id);
}
