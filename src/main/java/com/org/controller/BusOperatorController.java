package com.org.controller;

import java.time.LocalDate;

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

import com.org.entities.BusOperator;
import com.org.exceptions.InvalidUsernameException;
import com.org.service.IBusOperatorServiceImpl;

@RestController
@RequestMapping("/BusOperator")
public class BusOperatorController {

	@Autowired
	IBusOperatorServiceImpl BusOperator_service;

	@PostMapping("/add")
	public ResponseEntity<BusOperator> insertBusOperator(@RequestBody BusOperator busOperator) {
		busOperator = BusOperator_service.addBusOperator(busOperator);
		return new ResponseEntity<BusOperator>(busOperator, HttpStatus.OK);
	}

	@GetMapping("/{busOperatorUsername}")
	public ResponseEntity<BusOperator> getBusOperatorDetailsByUserName(@PathVariable String busOperatorUsername)
			throws Exception {
		BusOperator busOperator = BusOperator_service.getBusOperatorDetails(busOperatorUsername);
		return new ResponseEntity<BusOperator>(busOperator, HttpStatus.OK);
	}

	@PutMapping("/update/{busOperatorUsername}")
	public ResponseEntity<BusOperator> updateBusOperatorByUserName(@RequestBody BusOperator busOperator) {
		busOperator = BusOperator_service.updateBusOperatorDetails(busOperator);
		return new ResponseEntity<BusOperator>(busOperator, HttpStatus.OK);
	}

	@DeleteMapping("/deleteBusOperator/{busOperatorUsername}")
	public void deleteBusOperatorByUserName(@PathVariable("busOperatorUsername") String busOperatorUsername) {
		BusOperator_service.deleteBusOperatorByUserName(busOperatorUsername);
	}

	@PutMapping("/update/updatePassword/{username}/{newpassword}")
	public ResponseEntity<String> updatePassoword(@PathVariable String username, @PathVariable String newpassword)
			throws InvalidUsernameException {

		int count = BusOperator_service.updatePassoword(username, newpassword);
		if (count == 1) {
			return new ResponseEntity<String>("updated Password", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Not Updated", HttpStatus.OK);
		}
	}

	@GetMapping("/revenueByRouteId/{busrouteid}")
	public Double getRevenueByBusRoute(int busrouteid) {
		return BusOperator_service.getRevenueByBusRoute(busrouteid);

	}

	@GetMapping("/revenueByRouteIdandDate/{busrouteid}/{date}")
	public Double getRevenueByBusRouteAndDate(int busrouteid,
			@RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		return BusOperator_service.getRevenueByBusRouteAndDate(busrouteid, date);
	}

	@GetMapping("/monthlyRevenueByBusRoute/{busrouteid}/{month}")
	public Double getMonthlyRevenueByBusRoute(@PathVariable int busrouteid, @PathVariable int month) {
		return BusOperator_service.getMonthlyRevenueByBusRoute(busrouteid, month);
	}
	
	@GetMapping("/yearlyRevenueByBusRoute/{busrouteid}/{year}")
	public Double getYearlyRevenueByBusRoute(@PathVariable int busrouteid, @PathVariable int year) {
		return BusOperator_service.getYearlyRevenueByBusRoute(busrouteid, year);
	}

}
