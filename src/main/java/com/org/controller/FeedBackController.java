package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.entities.FeedBack;
import com.org.service.IFeedbackServiceImpl;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {
	@Autowired
	IFeedbackServiceImpl feedback_service;

	@PostMapping("/add")
	public ResponseEntity<FeedBack> insertfeedback(@RequestBody FeedBack feedback) {
		feedback = feedback_service.addFeedBack(feedback);
		return new ResponseEntity<FeedBack>(feedback, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FeedBack> getfeedbackDetailsById(@PathVariable int id) throws Exception {
		FeedBack feedback = feedback_service.getFeedBackDetailsById(id);
		return new ResponseEntity<FeedBack>(feedback, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<FeedBack> updateFeedBack(@RequestBody FeedBack feedback) {
		feedback = feedback_service.updateFeedBack(feedback);
		return new ResponseEntity<FeedBack>(feedback, HttpStatus.OK);
	}

	@DeleteMapping("/deletefeedback/{id}")
	public void deletefeedbackByID(@PathVariable("id") int feedbackId) {
		feedback_service.deleteFeedBackById(feedbackId);
	}

}
