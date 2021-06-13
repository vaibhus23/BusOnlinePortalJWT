package com.org.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.entities.User;
import com.org.exceptions.InvalidUsernameException;
import com.org.repository.IUserRepository;

@Service
@Transactional
public class IUserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository User_Repository;

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return User_Repository.save(user);
	}

	@Override
	public User getUserDetailsByUserName(String username) throws InvalidUsernameException {
		return User_Repository.findById(username).orElseThrow(()-> new InvalidUsernameException("username not found"));

	}

	@Override
	public void deleteUser(String username) throws InvalidUsernameException {
		Optional<User> findUserByusername = User_Repository.findById(username);
		if (findUserByusername.isPresent()) {
			User_Repository.deleteById(username);
		} else
			throw new InvalidUsernameException("Username Not Found to Delete");
	}

	@Override
	public void updatePassword(String username, String newPassword) {
		// TODO Auto-generated method stub

	}

	@Override
	public User singIn(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User singOut(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
