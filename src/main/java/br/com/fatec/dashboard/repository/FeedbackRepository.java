package br.com.fatec.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatec.dashboard.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
	
	

}
