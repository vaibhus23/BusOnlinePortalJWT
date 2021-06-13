package com.org.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user2")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@JsonIgnore
	@JoinColumn(name = "username")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Booking.class)
	private List<Booking> booking;

	//@JsonIgnore
	@JoinColumn(name = "username")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Passenger.class)
	private List<Passenger> passengersInfo;

	@JsonIgnore
	@JoinColumn(name = "username")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = FeedBack.class)
	private List<FeedBack> feedbackInfo;

	public List<FeedBack> getFeedbackInfo() {
		return feedbackInfo;
	}

	public void setFeedbackInfo(List<FeedBack> feedbackInfo) {
		this.feedbackInfo = feedbackInfo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	public List<Passenger> getPassengersInfo() {
		return passengersInfo;
	}

	public void setPassengersInfo(List<Passenger> passengersInfo) {
		this.passengersInfo = passengersInfo;
	}

}