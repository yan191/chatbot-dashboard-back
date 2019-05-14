package br.com.fatec.dashboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fatec.dashboard.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
	
	@Query("SELECT f.rating FROM Feedback f WHERE f.expectation = 'DONE'")
	List<Integer> findAllScore();
}
