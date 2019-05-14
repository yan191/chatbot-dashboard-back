package br.com.fatec.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatec.dashboard.model.Feedback;
import br.com.fatec.dashboard.service.FeedbackService;

@RestController
public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackService;
	
	@PostMapping("/responder")
	public ResponseEntity<Feedback> createNewFeedback(@RequestBody Feedback feedback){
		Feedback feed = feedbackService.save(feedback);
		return ResponseEntity.ok().body(feed);
	}
	
	@GetMapping("/feedbacks")
	public ResponseEntity<List<Feedback>> getAllFeedback(){
		List<Feedback> feedbacks = feedbackService.getAllFeedback();
		return ResponseEntity.ok().body(feedbacks);
	}

}
