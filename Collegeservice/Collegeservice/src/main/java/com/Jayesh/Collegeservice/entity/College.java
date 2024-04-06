package com.Jayesh.Collegeservice.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
@Component
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String collegename;
	@Transient
	private List<Student> students;
	public College(int id, String collegename, List<Student> students) {
		super();
		this.id = id;
		this.collegename = collegename;
		this.students = students;
	}
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCollegename() {
		return collegename;
	}
	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "College [id=" + id + ", collegename=" + collegename + ", students=" + students + "]";
	}
	
	
}
