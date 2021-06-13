package com.org.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fback")
public class FeedBack {

	@Id
	@GeneratedValue
	private int feedbackid;

	@Column(name = "rating")
	private int rating;

	@Column(name = "comment1")
	private String comment;

	@Column(name = "username")
	private String username;

	@Column(name = "routeName")
	private String routeName;

//	@JoinColumn(name = "busoperatorid")
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private BusOperator busOperator;

	public int getFeedbackid() {
		return feedbackid;
	}

	public void setFeedbackid(int feedbackid) {
		this.feedbackid = feedbackid;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

//	public BusOperator getBusOperator() {
//		return busOperator;
//	}
//
//	public void setBusOperator(BusOperator busOperator) {
//		this.busOperator = busOperator;
//	} 
//	

}
