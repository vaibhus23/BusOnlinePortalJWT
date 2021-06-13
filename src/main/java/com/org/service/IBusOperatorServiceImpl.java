package com.org.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.entities.BusOperator;
import com.org.exceptions.InvalidUsernameException;
import com.org.repository.IBusOperatorRepository;

@Service
@Transactional
public class IBusOperatorServiceImpl implements IBusOperatorService {

	@Autowired
	IBusOperatorRepository BusOperator_Repository;

	@Override
	public BusOperator addBusOperator(BusOperator busOperator) {
		return BusOperator_Repository.save(busOperator);
	}

	@Override
	public BusOperator updateBusOperatorDetails(BusOperator busOperator) {
		return BusOperator_Repository.save(busOperator);
	}

	@Override
	public BusOperator getBusOperatorDetails(String busOperatorUsername) throws InvalidUsernameException{
		return BusOperator_Repository.findById(busOperatorUsername).orElseThrow(() -> new InvalidUsernameException("UserName not Found"));
	}

	@Override
	public void deleteBusOperatorByUserName(String busOperatorUsername) {
		BusOperator_Repository.deleteById(busOperatorUsername);
	}
	
	@Override
	public int updatePassoword(String username, String newpassword) throws InvalidUsernameException {
		Optional<BusOperator> findBusOperatorByUsername = BusOperator_Repository.findById(username);
		if (findBusOperatorByUsername.isPresent()) {
			return BusOperator_Repository.updatePassoword(username, newpassword);
		} else
			throw new InvalidUsernameException("BusOperator username not exists!!");
	}
	
	@Override
	public Double getRevenueByBusRoute(int busrouteid) {
		return BusOperator_Repository.getRevenueByBusRoute(busrouteid);
	}

	@Override
	public Double getRevenueByBusRouteAndDate(int busrouteid, LocalDate date) {
		// TODO Auto-generated method stub
		return BusOperator_Repository.getRevenueByBusRouteIdAndDate(busrouteid, date);
	}

	@Override
	public Double getMonthlyRevenueByBusRoute(int busrouteid, int month) {
		// TODO Auto-generated method stub
		return BusOperator_Repository.getMonthlyRevenueByBusRoute(busrouteid, month);
	}

	@Override
	public Double getYearlyRevenueByBusRoute(int busrouteid, int year) {
		// TODO Auto-generated method stub
		return BusOperator_Repository.getYearlyRevenueByBusRoute(busrouteid, year);
	}
}
