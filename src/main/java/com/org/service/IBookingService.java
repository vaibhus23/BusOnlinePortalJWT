package com.org.service;

import java.time.LocalDate;
import java.util.List;
import com.org.entities.Booking;
import com.org.exceptions.InvalidBookingIdException;
import com.org.exceptions.InvalidBusRouteIDException;

public interface IBookingService {

	public Booking addBooking(Booking booking); // return booking id

	public Booking updateBooking(Booking booking) throws InvalidBookingIdException; // throws InvalidDateException;

	public String deleteBooking(int bookingId) throws InvalidBookingIdException;

	public Booking getBookingDetailsById(int bookingId) throws Exception;

	// public void addFeedBack(User user,long bookingId);
	public List<Booking> getAllBookingsByUserName(String username);

	public List<Booking> getAllBookingByDate(LocalDate date);

//	public List<Booking> getAllBookingByBusRoute(int busrouteid) throws InvalidBusRouteIDException;
	// public void addFeedback(String username,long bookingId,String msg);
	// public List<FeedBack> getFeedBackByBusRoute(String routeName)throws
	// InvalidBusRouteNameException;;

}
