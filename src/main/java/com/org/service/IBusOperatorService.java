package com.org.service;

import java.time.LocalDate;

import com.org.entities.BusOperator;
import com.org.exceptions.InvalidBusRouteIDException;
import com.org.exceptions.InvalidUsernameException;

public interface IBusOperatorService {

	public BusOperator addBusOperator(BusOperator busOperator);

	public BusOperator updateBusOperatorDetails(BusOperator busOperator);

	public BusOperator getBusOperatorDetails(String busOperatorUsername) throws Exception;

	public void deleteBusOperatorByUserName(String busOperatorUsername);

	public int updatePassoword(String username, String newpassword) throws InvalidUsernameException;

	public Double getRevenueByBusRoute(int busrouteid) throws InvalidBusRouteIDException;
	
	public Double getRevenueByBusRouteAndDate(int busrouteid, LocalDate date);
	
	public Double getMonthlyRevenueByBusRoute(int busrouteid,int month);
	
	public Double getYearlyRevenueByBusRoute(int busrouteid,int year);
}
