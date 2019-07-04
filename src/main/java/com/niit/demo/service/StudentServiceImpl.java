package com.niit.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.demo.domain.Student;
import com.niit.demo.domain.dto.StudentDto;
import com.niit.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public void add(StudentDto studentDto) {
		Student student = new Student();
		student.setName(studentDto.getName());
		studentRepository.save(student);
		
	}
	@Override
	public StudentDto get(Long myid) {
		Student student = new Student();
		student=studentRepository.findById(myid);
		StudentDto studentDto= new StudentDto();
		studentDto.setId(student.getId());
		studentDto.setName(student.getName());
		return studentDto;
	}

	@Override
	public void update(StudentDto studentDto) {
		Student student = new Student();
		Long myid = studentDto.getId();
		student=studentRepository.findById(myid);
		student.setName(studentDto.getName());
		studentRepository.save(student);
		
	}

	@Override
	public void delete(StudentDto studentDto) {
		// TODO Auto-generated method stub
		Student student = new Student();
		Long myid = studentDto.getId();
		student=studentRepository.findById(myid);
		studentRepository.delete(student);
	}


	
}
