package com.juned.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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

public class Quiz {
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	@JsonBackReference
	private User_entity user;
	@Transient
	private Long userId;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long quizId;
	private String title;
	@Column(nullable=false)
	private Boolean isStarted;
	
	@OneToMany(mappedBy="quiz",cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Question> question;
}
