package com.prim.controller;

import com.prim.dao.product.ProductDao;
import com.prim.dao.user.UserDao;
import com.prim.model.Product;
import com.prim.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
//@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private UserDao userDao;

    @RequestMapping("/product")
    public ResponseEntity<List<Product>> forA(){
        List<Product> products= (List<Product>) productDao.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping( "/user")
    public ResponseEntity<List<User>> getA(String email){
        List<User> user= (List<User>) userDao.findAll();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
