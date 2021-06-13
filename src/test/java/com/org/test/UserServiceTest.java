package com.org.test;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.org.entities.User;
import com.org.exceptions.InvalidUsernameException;
import com.org.repository.IUserRepository;
import com.org.service.IUserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private IUserServiceImpl userservice;

	@MockBean
	IUserRepository userrepository;

	// Checking for successfully adding of user into database
	@Test
	public void addUserValidTest() {
		User user = new User();
		user.setUsername("Vaibhav");
		user.setPassword("Vaibhav");
		Mockito.when(userrepository.save(user)).thenReturn(user);
		Assertions.assertThat(userservice.addUser(user)).isEqualTo(user);
	}

	@Test
	public void getUserDetailsByUserNameValidTest()  {

		User user = new User();
		user.setUsername("vaibhav");
		user.setPassword("vaibhav");
		Mockito.when(userrepository.findById("vaibhav")).thenReturn(Optional.of(user));
		try {
			Assertions.assertThat(userservice.getUserDetailsByUserName("vaibhav")).isEqualTo(user);
		} catch (InvalidUsernameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void deleteUserByUserNameValidTest() {
		User user = new User();
		user.setUsername("Vaibhav");
		user.setPassword("Vaibhav");
		try {
			userservice.deleteUser(user.getUsername());
		} catch (InvalidUsernameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//verify(userrepository, times(1)).deleteById(user.getPassword());
		
		
	}

}
