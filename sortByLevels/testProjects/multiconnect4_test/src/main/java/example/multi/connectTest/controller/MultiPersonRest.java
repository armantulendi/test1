package example.multi.connectTest.controller;


import example.multi.connectTest.model.example.Example;
import example.multi.connectTest.model.person.Person;
import example.multi.connectTest.repo.example.ExampleRepo;
import example.multi.connectTest.repo.person.PersonRepos;
import example.multi.connectTest.utils.EntityManagerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping(value = "/multiperson")
public class MultiPersonRest {

    @Autowired
//    @Qualifier("person")
    private PersonRepos repository;

//    @Autowired
////    @Qualifier("exampleRepo")
//    private  ExampleRepo exampleRepo;
    @Autowired
    private HttpServletRequest context;

    @Autowired
    private EntityManagerUtils emUtils;

    @RequestMapping(value = "/all")
    public Iterable<Person> getAll(){
        setRepository( context.getRequestURL().toString() );
        return repository.findAll();
    }
    @RequestMapping(value = "/single/{id}")
    public Optional<Person> getSingle(@PathVariable("id") Long id){
        setRepository( context.getRequestURL().toString() );
        return repository.findById(id);
    }
    private void setRepository(String url)  {
        repository = emUtils.getJpaFactory(url).getRepository(PersonRepos.class);
    }
//    @RequestMapping(value = "/example")
//    public Iterable<Example> getEx(){
//        setRepository( context.getRequestURL().toString() );
//        return exampleRepo.findAll();
//    }
}