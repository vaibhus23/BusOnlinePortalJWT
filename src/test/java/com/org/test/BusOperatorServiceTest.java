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

import com.org.entities.BusOperator;
import com.org.exceptions.InvalidUsernameException;
import com.org.repository.IBusOperatorRepository;
import com.org.service.IBusOperatorServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class BusOperatorServiceTest {

	@Autowired
	private IBusOperatorServiceImpl busoperatorserivce;

	@MockBean
	private IBusOperatorRepository busoperatorrepository;

	@Test
	public void addBusoperatorValidTest() {
		BusOperator busoperator = new BusOperator();
		busoperator.setBusOperatorUsername("Vaibhav");
		busoperator.setPassword("Vaibhav");
		Mockito.when(busoperatorrepository.save(busoperator)).thenReturn(busoperator);
		Assertions.assertThat(busoperatorserivce.addBusOperator(busoperator)).isEqualTo(busoperator);
	}

	@Test
	public void updateBusOperatorDetailsTest() {
		BusOperator busoperator = new BusOperator();
		busoperator.setBusOperatorUsername("Vaibhav");
		busoperator.setPassword("Vaibhav");
		Mockito.when(busoperatorrepository.save(busoperator)).thenReturn(busoperator);
		Assertions.assertThat(busoperatorserivce.updateBusOperatorDetails(busoperator)).isEqualTo(busoperator);
	}

	@Test
	public void getBusOperatorDetails() {
		BusOperator busoperator = new BusOperator();
		busoperator.setBusOperatorUsername("Vaibhav");
		busoperator.setPassword("Vaibhav");
		Mockito.when(busoperatorrepository.findById("vaibhav")).thenReturn(Optional.of(busoperator));
		try {
			Assertions.assertThat(busoperatorserivce.getBusOperatorDetails("vaibhav")).isEqualTo(busoperator);
		} catch (InvalidUsernameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void deleteBusOperatorByUserName() {
		BusOperator busoperator = new BusOperator();
		busoperator.setBusOperatorUsername("Vaibhav");
		busoperator.setPassword("Vaibhav");
		busoperatorserivce.deleteBusOperatorByUserName(busoperator.getBusOperatorUsername());
	}

}
