package com.niit.demo.domain.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {
	
	private Long id;
	
	@Size(min = 2, max = 5, message 
		      = "About Me must be between 10 and 200 characters")
	
	@NotEmpty
	private String name;

}
