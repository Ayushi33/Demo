package com.niit.demo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.demo.domain.Student;
import com.niit.demo.domain.dto.StudentDto;
import com.niit.demo.repository.StudentRepository;
import com.niit.demo.service.StudentServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {
	 @InjectMocks
	StudentServiceImpl studentService;
	
	 @Mock
	    StudentRepository studentRepository;
	 
	 @Test
		public void testContextLoaded() {
			assertNotNull(studentService);
		}
//	  @Test
//	    public void test_add() throws Exception{
//		  Student student = new Student();
//		  StudentDto studentDto = new StudentDto ();
//		  studentDto.setName("äyushiooooooooooooooooo");
//	  Mockito.doNothing().when(studentRepository).save(student);
//		studentService.add(studentDto);
}
