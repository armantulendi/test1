package com.devglan.controller;

import java.util.List;
import java.util.Optional;

import com.devglan.booking.dao.BookingDao;
import com.devglan.model.UserDetails;
import com.devglan.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devglan.model.Booking;
import com.devglan.service.BookingService;

@Controller
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	@Autowired
	private BookingDao bookingDao;
	@Autowired
	private UserDao userDao;
	@GetMapping(value = "/book")
		public Iterable<Booking> getP(){

		return bookingDao.findAll();
		}
	@GetMapping(value = "/user/{email}")
	public ResponseEntity<List<UserDetails>>  forUser(@PathVariable(name = "email")String email){
		 List<UserDetails> user=userDao.findAll();
		return new ResponseEntity<List<UserDetails>>( user, HttpStatus.OK);
	}
	@RequestMapping(value = "/{email:.+}", method = RequestMethod.GET)
	public ResponseEntity<List<Booking>> findUserBookings(@PathVariable(name = "email", value = "email") String email) {

		List<Booking> bookings = bookingService.findUserBookings(email);
		return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK);
	}

}
