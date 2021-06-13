package com.org.exceptions;

public class InvalidBusRouteIDException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String s;

	public InvalidBusRouteIDException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
