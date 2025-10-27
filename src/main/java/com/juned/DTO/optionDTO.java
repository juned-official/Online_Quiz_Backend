package com.juned.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class optionDTO {
	private String optionText;
	private Boolean isCorrect;
}
