package example.multi.connectTest2.controller;
import example.multi.connectTest2.model.person.Person;
import example.multi.connectTest2.repo.person.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person")
public class PersonRest {

    @Autowired
    private PersonRepo repository;

    @RequestMapping(value = "/all")
    public Iterable<Person> getAll(){
        return repository.findAll();
    }
}