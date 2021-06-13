package com.org.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue
	private int bookingId;

	@Column(name = "username")
	private String username;

	@Column(name = "busnumber")
	private String busNumber;

	@Column(name = "numberofseats")
	private int numberOfSeats;

	@Column(name = "amountpaid")
	private int amountPaid;

	@Column(name = "bookingdate")
	private LocalDate date;

	@Column(name = "journeystarttime")
	private LocalDateTime journeyStartTime;

	@Column(name = "journeyendtime")
	private LocalDateTime journeyEndTime;

	@Column(name = "source")
	private String source;

	@Column(name = "destination")
	private String destination;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public int getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDateTime getJourneyStartTime() {
		return journeyStartTime;
	}

	public void setJourneyStartTime(LocalDateTime journeyStartTime) {
		this.journeyStartTime = journeyStartTime;
	}

	public LocalDateTime getJourneyEndTime() {
		return journeyEndTime;
	}

	public void setJourneyEndTime(LocalDateTime journeyEndTime) {
		this.journeyEndTime = journeyEndTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
