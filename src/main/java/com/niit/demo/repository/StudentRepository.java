package com.niit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niit.demo.domain.Student;


public interface StudentRepository extends JpaRepository<Student , String> {
 
public Student findById(Long myid);
}
