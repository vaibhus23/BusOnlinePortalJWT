package com.org.test;

import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.org.entities.FeedBack;
import com.org.repository.IFeedBackRepository;
import com.org.service.IFeedbackServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class FeedbackTestService {
	@Autowired
	IFeedbackServiceImpl feedbackService;

	@MockBean
	IFeedBackRepository feedbackRepository;

	@Test
	public void addFeedback() {
		FeedBack feedback = new FeedBack();
		feedback.setFeedbackid(1);
		Mockito.when(feedbackRepository.save(feedback)).thenReturn(feedback);
		Assertions.assertThat(feedbackService.addFeedBack(feedback)).isEqualTo(feedback);
	}

	public void getFeedbackDetailsById() {
		FeedBack feedback = new FeedBack();
		feedback.setFeedbackid(1);
		Mockito.when(feedbackRepository.findById(1)).thenReturn(Optional.of(feedback));
		try {
			Assertions.assertThat(feedbackService.getFeedBackDetailsById(1)).isEqualTo(feedback);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateFeedBack() {
		FeedBack feedback = new FeedBack();
		feedback.setFeedbackid(1);
		Mockito.when(feedbackRepository.findById(1)).thenReturn(Optional.of(feedback));
		Mockito.when(feedbackRepository.save(feedback)).thenReturn(feedback);
		Assertions.assertThat(feedbackService.updateFeedBack(feedback)).isEqualTo(feedback);
	}

	public void deletePassengerById() {
		FeedBack feedback = new FeedBack();
		feedback.setFeedbackid(1);
		Mockito.when(feedbackRepository.findById(1)).thenReturn(Optional.of(feedback));
		feedbackService.deleteFeedBackById(feedback.getFeedbackid());

	}
}
