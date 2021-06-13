package com.org.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "busoperatorrequest")
public class BusOperatorRequest {

	@Id
	@GeneratedValue
	@Column(name = "casenumber")
	private int caseNumber;

	@Column(name = "busoperatorusername")
	private String busOperatorUsername;

	@Column(name = "requestmsg")
	private String requestMsg;

	@Column(name = "requestfor")
	private String requestFor; // Possible values deleteBus,update Fare,Change Route , Change Time

	@Column(name = "status")
	private boolean status; // approved = true , unapproved = false

	@Column(name = "requestdate")
	private LocalDate requestDate;

	@JoinColumn(name = "busid")
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Bus bus;

	public int getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(int caseNumber) {
		this.caseNumber = caseNumber;
	}

	public String getBusOperatorUsername() {
		return busOperatorUsername;
	}

	public void setBusOperatorUsername(String busOperatorUsername) {
		this.busOperatorUsername = busOperatorUsername;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public String getRequestMsg() {
		return requestMsg;
	}

	public void setRequestMsg(String requestMsg) {
		this.requestMsg = requestMsg;
	}

	public String getRequestFor() {
		return requestFor;
	}

	public void setRequestFor(String requestFor) {
		this.requestFor = requestFor;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public LocalDate getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(LocalDate requestDate) {
		this.requestDate = requestDate;
	}

}
