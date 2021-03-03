package example.multi.connect.controller;


import example.multi.connect.model.Person;
import example.multi.connect.repo.PersonRepo;
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