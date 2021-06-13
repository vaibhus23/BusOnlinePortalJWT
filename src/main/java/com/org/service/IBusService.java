package com.org.service;

import com.org.entities.Bus;

public interface IBusService {
	public Bus addBus(Bus bus);
	public Bus updateBus(Bus bus);
	public Bus getBusDetailsById(int busId) throws Exception;
	public void deleteBusIdById(int busId); 
}
