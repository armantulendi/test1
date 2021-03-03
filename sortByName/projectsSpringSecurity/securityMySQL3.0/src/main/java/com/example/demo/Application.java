package com.example.demo;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        UserService userService=new UserService();
        User user = new User("Masha",26);
        userService.saveUser(user);
        SpringApplication.run(Application.class, args);
    }

}
