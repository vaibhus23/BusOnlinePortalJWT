package com.org.service;

import com.org.entities.User;
import com.org.exceptions.InvalidUsernameException;

public interface IUserService {
	public User addUser(User user);

	public void deleteUser(String username)throws InvalidUsernameException;

	public void updatePassword(String username, String newPassword);

	public User getUserDetailsByUserName(String Username) throws InvalidUsernameException;

	public User singIn(User user);

	public User singOut(User user);

}
