package com.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.entities.Passenger;
import com.org.repository.IPassengerRepository;

@Service
@Transactional
public class IPassengerServiceImpl implements IPassengerService{
	
	@Autowired
	private IPassengerRepository Passenger_Repository;

	@Override
	public Passenger addPassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		return Passenger_Repository.save(passenger);
	}

	@Override
	public Passenger updatePassenger(Passenger passenger) {
		return Passenger_Repository.save(passenger);
	}

	@Override
	public Passenger getPassengerDetailsById(int passengerId) throws Exception {
		// TODO Auto-generated method stub
		return Passenger_Repository.findById(passengerId).orElseThrow(() -> new Exception("Element no Found"));
	}

	@Override
	public void deletePassengerById(int passengerId){
		// TODO Auto-generated method stub
		Passenger_Repository.deleteById(passengerId);
	}

}
