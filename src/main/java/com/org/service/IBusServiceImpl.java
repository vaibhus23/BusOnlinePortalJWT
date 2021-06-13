package com.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.entities.Bus;
import com.org.repository.IBusRepository;
@Service
@Transactional
public class IBusServiceImpl implements IBusService{
	@Autowired
	private IBusRepository Bus_Repository;
	
	@Override
	public Bus addBus(Bus bus) {
		// TODO Auto-generated method stub
		return Bus_Repository.save(bus);
	}

	@Override
	public Bus updateBus(Bus bus) {
		// TODO Auto-generated method stub
		return Bus_Repository.save(bus);
	}

	@Override
	public Bus getBusDetailsById(int busId) throws Exception {
		// TODO Auto-generated method stub
		return Bus_Repository.findById(busId).orElseThrow(() -> new Exception("Element no Found"));
	}

	@Override
	public void deleteBusIdById(int busId) {
		// TODO Auto-generated method stub
		Bus_Repository.deleteById(busId);
	}

}
