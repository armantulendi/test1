package example.multi.connectTest.controller;

import example.multi.connectTest.model.person.Person;
import example.multi.connectTest.repo.person.PersonRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person")
public class PersonRest {
    @Autowired
    private PersonRepos repository;

    @RequestMapping(value = "/all")
    public Iterable<Person> getAll(){
        return repository.findAll();
    }
}