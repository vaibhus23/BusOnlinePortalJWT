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

import com.org.entities.Passenger;
import com.org.repository.IPassengerRepository;
import com.org.service.IPassengerServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class PassengerServiceTest {

	@Autowired
	IPassengerServiceImpl passengerservice;

	@MockBean
	IPassengerRepository passengerrepository;

	@Test
	public void addPassenger() {
		Passenger passenger = new Passenger();
		passenger.setPassengerid(1);
		Mockito.when(passengerrepository.save(passenger)).thenReturn(passenger);
		Assertions.assertThat(passengerservice.addPassenger(passenger)).isEqualTo(passenger);
	}

	@Test
	public void getPassengerDetailsById() {
		Passenger passenger = new Passenger();
		passenger.setPassengerid(1);
		Mockito.when(passengerrepository.findById(1)).thenReturn(Optional.of(passenger));
		try {
			Assertions.assertThat(passengerservice.getPassengerDetailsById(1)).isEqualTo(passenger);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void updatePassenger() {
		Passenger passenger = new Passenger();
		passenger.setPassengerid(1);
		Mockito.when(passengerrepository.findById(1)).thenReturn(Optional.of(passenger));
		Mockito.when(passengerrepository.save(passenger)).thenReturn(passenger);
		Assertions.assertThat(passengerservice.updatePassenger(passenger)).isEqualTo(passenger);
	}

	@Test
	public void deletePassengerById() {
		Passenger passenger = new Passenger();
		passenger.setPassengerid(1);
		Mockito.when(passengerrepository.findById(1)).thenReturn(Optional.of(passenger));
		passengerservice.deletePassengerById(passenger.getPassengerid());

	}

}
