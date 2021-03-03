package com.example.multi.controller;

import com.example.multi.config.BookConfig;
import com.example.multi.config.UserConfig;
import com.example.multi.connectToTwo.MySqlConnection;
import com.example.multi.dao.book.BookDao;
import com.example.multi.dao.user.UserDao;
import com.example.multi.model.Book;
import com.example.multi.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
@EnableTransactionManagement
public class UserController {
    BookConfig bookConfig;
     @Autowired
    private UserDao userDao;
    @Autowired
    private BookDao bookDao;

    private Book book;



    @GetMapping("/user")
    public Iterable<User> getUser(){

        return userDao.findAll();
    }
    @GetMapping("/book")
    public Iterable<Book> getBook(){

        return bookDao.findAll();
    }
    @GetMapping("/databases/view")
//    @Transactional("bookTransactionManager")
    public String getBookView(Model model){
//        try {
//            new BookConfig().bookDataSource().getConnection().createStatement().execute("select 1");
//            System.out.println("connect");
//        } catch (SQLException throwable) {
//            System.out.println("disconnect");
//        }

//        try {
//            new UserConfig().userDataSource().getConnection().createStatement().execute("select 1");
//        } catch (SQLException throwables) {
//            System.out.println("asdfasfs");
//        }

        bookDao.findAll();
        model.addAttribute("books",bookDao.findAll());
        model.addAttribute("users",userDao.findAll());

        return "forBook";
    }


    @PostMapping("/databases/view")
    public String postMap(
            @ModelAttribute  Book book,
            Model model){
           Book books = bookDao.getOne(book.getId());
           books.setDropAddress(book.getDropAddress());
           books.setBookingAmount(book.getBookingAmount());
           books.setPickupAddress(book.getPickupAddress());
           books.setCreatedBy(book.getCreatedBy());
           bookDao.saveAndFlush(books);

        return "redirect:/databases/view";
    }

    @GetMapping("/databases/user")
    public String getUser(
            @ModelAttribute User user,
            Model model ){
        model.addAttribute("users", userDao.findAll());
        return "forUser";
    }

    @PostMapping("/databases/user")
    @Transactional("userTransactionManager")
    public String postUser(
//            @ModelAttribute User user,
            @RequestParam("userId") Integer userId,
            @RequestParam("userStr") String userStr,
            Model model ){
        User users = userDao.getOne(userId) ;
        users.setUserId(userId);
        users.setStr(userStr);
        userDao.save(users);
        return "redirect:/databases/view";
    }
//    @Transactional("userTransactionManager")
//    public void connect(){
//        String url="jdbc:mysql://localhost:3306/datasource1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//        String username="spring";
//        String password="P@ssword1";
//
//        try(Connection conn= DriverManager.getConnection(url,username,password);
//            Statement statement=conn.createStatement()) {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            statement.execute("select 1");
//            System.out.println("connected");
//        }
//        catch(SQLException | ClassNotFoundException e){
//            System.out.println(e.getMessage());
//        }
//    }

}
