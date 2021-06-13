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

import com.org.entities.Bus;
import com.org.service.IBusServiceImpl;

@RestController
@RequestMapping("/bus")
public class IBusController {

	@Autowired
	IBusServiceImpl bus_service;

	@PostMapping("/add")
	public ResponseEntity<Bus> insertBus(@RequestBody Bus bus) {
		bus = bus_service.addBus(bus);
		return new ResponseEntity<Bus>(bus, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Bus> getBusDetailsById(@PathVariable int id) throws Exception {
		Bus Bus = bus_service.getBusDetailsById(id);
		return new ResponseEntity<Bus>(Bus, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Bus> updateBus(@RequestBody Bus bus) {
		bus = bus_service.updateBus(bus);
		return new ResponseEntity<Bus>(bus, HttpStatus.OK);
	}

	@DeleteMapping("/deleteBus/{id}")
	public void deleteBusByID(@PathVariable("id") int busId) {
		bus_service.deleteBusIdById(busId);
	}
}
