package br.com.fatec.dashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.dashboard.model.Feedback;
import br.com.fatec.dashboard.repository.FeedbackRepository;

@Service
public class FeedbackService {
	
	@Autowired
	FeedbackRepository feedbackRepository;
	
	public Feedback save(Feedback feedback) {
		Feedback feed = new Feedback();
		feed.setExpectation(feedback.getExpectation());
		feed.setTimePlayed(feedback.getTimePlayed());
		feed.setRating(feedback.getRating());
		feedbackRepository.save(feed);
		return feed;
	}
	
	public List<Feedback> getAllFeedback() {
		return feedbackRepository.findAll();
	}

}
