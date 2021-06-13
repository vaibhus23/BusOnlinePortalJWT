package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.entities.User;

public interface IUserRepository extends JpaRepository<User, String> {

//	@Query(value = "select * from User2 u where u.username=?1", nativeQuery = true)
//	public User getUserDetailsByUserName(String Username);

	@Query(value = "delete from User2 u where u.username=?1", nativeQuery = true)
	public void deleteUser(String username);

}
