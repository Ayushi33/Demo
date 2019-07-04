package com.niit.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.niit.demo.controller.StudentController;
import com.niit.demo.domain.dto.StudentDto;
import com.niit.demo.repository.StudentRepository;
import com.niit.demo.service.StudentService;


import junit.framework.TestCase;
import junit.framework.TestSuite;

@RunWith(SpringRunner.class)
@WebMvcTest(value = StudentController.class, secure = false)
public class AppTestController{
  
@Autowired
	private MockMvc mockMvc;
	@MockBean
	StudentService studentService;
	@MockBean
	private StudentRepository studentRepository;
   
	@Test
	public void testContextLoaded() {
		assertNotNull(studentService);  
	}
	@Test
	public void testadd() throws Exception {
		 StudentDto studentDto = new  StudentDto();
		 studentDto.setName("ayushi");
		 studentDto.setId(11L);
		
		 String dto = "{\"id\" :5,\"name\" : \"ayuu\"}";
		
		Mockito.doNothing().when(studentService).add(studentDto);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
                "/student/add").accept(MediaType.APPLICATION_JSON).content(dto).contentType(MediaType.APPLICATION_JSON);

		
		 MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(201, response.getStatus());
       
	}
	@Test
	public void testget() throws Exception {
		StudentDto studentDto = new  StudentDto();
		Mockito.when(studentService.get(11L)).thenReturn(studentDto);
	
		  RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
	                "/student/get/11").accept(MediaType.APPLICATION_JSON);


	        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

	        MockHttpServletResponse response = result.getResponse();
	        assertEquals(200, response.getStatus());
	
	}
	@Test
	public void testupdate() throws Exception {
		StudentDto studentDto = new  StudentDto();
	studentDto.setId(11L);
	studentDto.setName("ayushi");
	
	 String dto = "{\"id\" :5,\"name\" : \"ayuu\"}";
	 Mockito.doNothing().when(studentService).update(studentDto);

	 RequestBuilder requestBuilder = MockMvcRequestBuilders.put(
             "/student/update").accept(MediaType.APPLICATION_JSON).content(dto).contentType(MediaType.APPLICATION_JSON);

		
		 MvcResult result = mockMvc.perform(requestBuilder).andReturn();

     MockHttpServletResponse response = result.getResponse();
     assertEquals(201, response.getStatus());;
	
	
	}
	@Test
	public void testdelete() throws Exception {
		StudentDto studentDto = new  StudentDto();
	studentDto.setId(11L);
	studentDto.setName("ayushi");
	
	 String dto = "{\"id\" :5,\"name\" : \"ayuu\"}";
	 Mockito.doNothing().when(studentService).delete(studentDto);

	 RequestBuilder requestBuilder = MockMvcRequestBuilders.put(
             "/student/delete").accept(MediaType.APPLICATION_JSON).content(dto).contentType(MediaType.APPLICATION_JSON);

		
		 MvcResult result = mockMvc.perform(requestBuilder).andReturn();

     MockHttpServletResponse response = result.getResponse();
     assertEquals(201, response.getStatus());;
	
	
	}
	
}