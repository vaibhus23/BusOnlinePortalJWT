package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.entities.Passenger;
import com.org.service.IPassengerServiceImpl;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

	@Autowired
	IPassengerServiceImpl passenger_service;

	@PostMapping("/add")
	public ResponseEntity<Passenger> insertpassenger(@RequestBody Passenger passenger) {
		passenger = passenger_service.addPassenger(passenger);
		return new ResponseEntity<Passenger>(passenger, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Passenger> getpassengerDetailsById(@PathVariable int id) throws Exception {
		Passenger passenger = passenger_service.getPassengerDetailsById(id);
		return new ResponseEntity<Passenger>(passenger, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Passenger> updatePassenger(@RequestBody Passenger passenger) {
		passenger = passenger_service.updatePassenger(passenger);
		return new ResponseEntity<Passenger>(passenger, HttpStatus.OK);
	}

	@DeleteMapping("/deletepassenger/{id}")
	public void deletepassengerByID(@PathVariable("id") int passengerId) {
		passenger_service.deletePassengerById(passengerId);
	}

}
