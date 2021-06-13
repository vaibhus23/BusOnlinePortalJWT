package com.org.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.entities.Booking;
import com.org.exceptions.InvalidBookingIdException;
import com.org.service.IBookingServiceImpl;


@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	IBookingServiceImpl booking_service;

	@PostMapping("/add")
	public ResponseEntity<Booking> insertBooking(@RequestBody Booking booking) {
		booking = booking_service.addBooking(booking);
		return new ResponseEntity<Booking>(booking, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Booking> getBookingDetailsById(@PathVariable int id) throws Exception {
		Booking booking = booking_service.getBookingDetailsById(id);
		return new ResponseEntity<Booking>(booking, HttpStatus.OK);
	}

	@PutMapping("/updateBooking")
	
	public void modifyBooking(@RequestBody Booking updateBooking) throws InvalidBookingIdException {
		booking_service.updateBooking(updateBooking);
	}
	
	@DeleteMapping("/deleteBooking/{id}")
	
	public void deleteBookingByID(@PathVariable("id") int bookingId) throws InvalidBookingIdException {

		booking_service.deleteBooking(bookingId);
	}
	
	@GetMapping("/byUserName/{username}")
	public List<Booking> getBookingByUserName(@PathVariable String username) {
		return booking_service.getAllBookingsByUserName(username);
	}

	@GetMapping("/byDate/{date}")
	public List<Booking> getBookingByDate(
			@RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		return booking_service.getAllBookingByDate(date);
	}
}
