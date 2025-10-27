package com.juned.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long question_id;
	@ManyToOne
	@JoinColumn(name="quiz_id")
	@JsonBackReference
	private Quiz quiz;
	
	private String questionType;
	private String text;
	
	@OneToMany(mappedBy="question", cascade=CascadeType.ALL,orphanRemoval=true)
	@JsonManagedReference
	private List<Option> options;
	
}
