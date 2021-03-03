package com.example.multiconnect6_test;

import com.example.multiconnect6_test.book.repository.BookRepository;
import com.example.multiconnect6_test.model.book.Book;
import com.example.multiconnect6_test.model.user.User;
import com.example.multiconnect6_test.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@RestController
public class Multiconnect6TestApplication {

	@Autowired
	private BookRepository bookRepository;
	@PostConstruct
	public void addData2B(){
		userRepository.saveAll(Stream.of(new User(744,"John"),new User(455,"Pitter")).collect(Collectors.toList()));
		bookRepository.saveAll(Stream.of(new Book(111,"Spring Book"),new Book(222,"for java")).collect(Collectors.toList()));

	}
	@GetMapping("/getUsers")
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	@GetMapping("/getBooks")
	public List<Book> getBooks(){
		return bookRepository.findAll();
	}
	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(Multiconnect6TestApplication.class, args);
	}

}
