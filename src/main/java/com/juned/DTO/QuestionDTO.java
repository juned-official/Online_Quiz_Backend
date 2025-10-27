package com.juned.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class QuestionDTO {
	private String questionType;
	private String text;
	private List<optionDTO> options;
}
