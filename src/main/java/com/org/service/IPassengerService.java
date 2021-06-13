package com.org.service;

import com.org.entities.Passenger;

public interface IPassengerService {
	
	public Passenger addPassenger(Passenger passenger);
	public Passenger updatePassenger(Passenger passenger);
	public Passenger getPassengerDetailsById(int passengerId) throws Exception;
	public void deletePassengerById(int passengerId); 
}
