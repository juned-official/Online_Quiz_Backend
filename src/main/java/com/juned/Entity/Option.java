package com.juned.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Options")
public class Option {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Option_id;
	private String optionText;
	private Boolean isCorrect;
	@ManyToOne
	@JoinColumn(name="question_ID")
	@JsonBackReference
	private Question question;
}
