package com.juned.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDTO {
	private String title;
	private Boolean isStarted;
	private Long userId;
	private List<QuestionDTO> question;
}


