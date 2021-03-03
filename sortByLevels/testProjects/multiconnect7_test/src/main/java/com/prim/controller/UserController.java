//package com.prim.controller;
//
//import com.prim.dao.user.UserDao;
//import com.prim.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//@RestController
//@RequestMapping("/user")
//public class UserController {
//    @Autowired
//    private UserDao userDao;
//
//    @GetMapping(name = "/user")
//    public ResponseEntity<List<User>> getA(String email){
//        List<User> user= (List<User>) userDao.findAll();
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//}
