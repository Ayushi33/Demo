package com.niit.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "student_entity")
public class Student {
	@Id
	@GeneratedValue(generator = "student_seq")
	@GenericGenerator(name = "student_seq", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence_name", value = "student_entity_id_seq"),
			@org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
	@Column(name = "id", unique = true, nullable = false)
	private Long id ;
	
	@Column(name = "name",nullable=false)
	private String name;
}
