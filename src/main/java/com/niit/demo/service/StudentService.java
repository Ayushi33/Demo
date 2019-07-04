package com.niit.demo.service;

import com.niit.demo.domain.dto.StudentDto;

public interface StudentService {

	void add(StudentDto studentDto);
	
	

	StudentDto get(Long myid);



	void update(StudentDto studentDto);



	void delete(StudentDto studentDto);


}
