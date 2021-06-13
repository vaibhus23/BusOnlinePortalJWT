package com.org.service;

import com.org.entities.FeedBack;

public interface IFeedBackService {
	public FeedBack addFeedBack(FeedBack feedback);
	public FeedBack updateFeedBack(FeedBack feedback);
	public FeedBack getFeedBackDetailsById(int feedbackId) throws Exception;
	public void deleteFeedBackById(int feedbackId); 

}
