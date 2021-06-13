package com.org.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "busroute")
public class BusRoute {

	@Id
	@GeneratedValue
	@Column(name = "busrouteid")
	private int busrouteid;

	@Column(name = "routename")
	private String routeName; // unique

	@Column(name = "source")
	private String source;

	@Column(name = "destination")
	private String destination;

	public int getBusrouteid() {
		return busrouteid;
	}

	public void setBusrouteid(int busrouteid) {
		this.busrouteid = busrouteid;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

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

}
