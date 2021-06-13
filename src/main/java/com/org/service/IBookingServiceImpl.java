package com.org.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.entities.Booking;
import com.org.exceptions.InvalidBookingIdException;
import com.org.repository.IBookingRepository;

@Service
@Transactional
public class IBookingServiceImpl implements IBookingService {

	@Autowired
	private IBookingRepository Booking_Repository;

	@Override
	public Booking addBooking(Booking booking) {

		return Booking_Repository.save(booking);
	}

	@Override
	public Booking getBookingDetailsById(int bookingId) throws Exception {

		return Booking_Repository.findById(bookingId).orElseThrow(() -> new Exception("Element not found"));
	}

	@Override
	public Booking updateBooking(Booking booking) throws InvalidBookingIdException {
		Optional<Booking> findBookingById = Booking_Repository.findById(booking.getBookingId());
		if (findBookingById.isPresent()) {
			Booking_Repository.save(booking);
		} else
			throw new InvalidBookingIdException("Booking with Booking Id: " + booking.getBookingId() + " not exists!!");
		return booking;
	}

	@Override
	public String deleteBooking(int bookingId) throws InvalidBookingIdException {
		Optional<Booking> findBookingById = Booking_Repository.findById(bookingId);
		if (findBookingById.isPresent()) {
			Booking_Repository.deleteById(bookingId);
			return "Booking Deleted!!";
		} else
			throw new InvalidBookingIdException("Booking not found for the entered BookingID");
	}

	@Override
	public List<Booking> getAllBookingsByUserName(String username) {
		return Booking_Repository.getAllBookingsByUserName(username);
	}

	@Override
	public List<Booking> getAllBookingByDate(LocalDate date) {
		return Booking_Repository.getAllBookingByDate(date);
	}

//	@Override
//	public List<Booking> getAllBookingByBusRoute(int busrouteid) throws InvalidBusRouteIDException {
//		// TODO Auto-generated method stub
//		Optional<Booking> findAllBookingByBusrouteId = Booking_Repository.findById(busrouteid);
//		if (findAllBookingByBusrouteId.isPresent()) {
//			return Booking_Repository.getAllBookingByBusRoute(busrouteid);
//		} else
//			throw new InvalidBusRouteIDException("Booking not found for the entered BookingID");
//	}

}
