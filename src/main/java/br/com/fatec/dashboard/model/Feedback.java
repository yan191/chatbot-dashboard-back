package br.com.fatec.dashboard.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import br.com.fatec.dashboard.enums.ExpectationStatus;

@Entity
@Table(name="feedback")
public class Feedback {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Enumerated(EnumType.STRING)
	private ExpectationStatus expectation;
	private Integer rating = 0;
	private Integer timePlayed = 0;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ExpectationStatus getExpectation() {
		return expectation;
	}
	public void setExpectation(ExpectationStatus expectation) {
		this.expectation = expectation;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Integer getTimePlayed() {
		return timePlayed;
	}
	public void setTimePlayed(Integer timePlayed) {
		this.timePlayed = timePlayed;
	}

}
