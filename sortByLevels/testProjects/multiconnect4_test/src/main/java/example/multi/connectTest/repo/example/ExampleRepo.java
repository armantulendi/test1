package example.multi.connectTest.repo.example;

import example.multi.connectTest.model.example.Example;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
@Service
public interface ExampleRepo extends CrudRepository<Example,Long> {

}
