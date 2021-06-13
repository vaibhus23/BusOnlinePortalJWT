package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.entities.User;
import com.org.exceptions.InvalidUsernameException;
import com.org.service.IUserServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/User")
public class UserController {

	@Autowired
	IUserServiceImpl User_service;

	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		return User_service.addUser(user);
	}

	@GetMapping("/byUserName/{username}")
	public User getUserByUserName(@PathVariable String username)throws InvalidUsernameException {
		return User_service.getUserDetailsByUserName(username);
	}

	@DeleteMapping("/deletebyUserName/{username}")
	public void deleteByUserName(@PathVariable String username) throws InvalidUsernameException{
		 User_service.deleteUser(username);
	}
}