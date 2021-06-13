package com.org.test;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.org.entities.Booking;
import com.org.repository.IBookingRepository;
import com.org.service.IBookingServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookingServiceTest {

	@Autowired
	private IBookingServiceImpl bookingservice;
	
	@MockBean
	private IBookingRepository bookingrepository;
	
	@Test
	private void addBooking() {
		Booking booking = new Booking();
		booking.setBookingId(1);
		Mockito.when(bookingrepository.save(booking)).thenReturn(booking);
		Assertions.assertThat(bookingservice.addBooking(booking)).isEqualTo(booking);
	}
	
   @Test
   private void getBookingDetailsById() {
	   Booking booking = new Booking();
		booking.setBookingId(1);
		Mockito.when(bookingrepository.findById(1)).thenReturn(Optional.of(booking));
		try {
			Assertions.assertThat(bookingservice.getBookingDetailsById(1)).isEqualTo(booking);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
   
}
