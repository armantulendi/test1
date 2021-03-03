package com.multiconnect.service;

import com.multiconnect.books.dao.BookDao;
import com.multiconnect.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BookDao bookingDao;

    public List findUserBookings(String emailId) {
        UserDetails userdetails = userDao.findByEmail(emailId);
        List bookings = bookingDao.findByCreatedBy(userdetails.getId());
        return bookings;
    }
}