package com.niit.demo.controller;

import java.security.Principal;
import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.demo.domain.dto.StudentDto;
import com.niit.demo.service.StudentService;
import com.niit.demo.service.StudentServiceImpl;


@RestController
@RequestMapping("/student")
public class StudentController {
	 @Autowired
	 StudentService studentService;
	 
	 @PostMapping(value = "/add")
	 public ResponseEntity<String> add(@RequestBody @Valid StudentDto studentDto) {
		 studentService.add(studentDto);

	        return new ResponseEntity<>("Ayushi", HttpStatus.CREATED);
	    }
	 
	
	 @GetMapping(value = "/get/{id}")
	 public ResponseEntity<StudentDto> get(@PathVariable("id") Long myid  ) {
		 StudentDto studentDto= null;
		 studentDto= studentService.get(myid);

	        return new ResponseEntity<>(studentDto, HttpStatus.OK);
	    }
	 @PutMapping(value = "/update")
	 public ResponseEntity<String> update(@RequestBody StudentDto studentDto ) {
		 
		  studentService.update(studentDto);

	        return new ResponseEntity<>("Ayushi", HttpStatus.CREATED);
	    }
	 @PutMapping(value = "/delete")
	 public ResponseEntity<String> delete(@RequestBody StudentDto studentDto ) {
		 
		  studentService.delete(studentDto);

	        return new ResponseEntity<>("Ayushi", HttpStatus.CREATED);
	    }

}
