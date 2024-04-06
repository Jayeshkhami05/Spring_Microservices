package com.Jayesh.Studentservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jayesh.Studentservice.Entity.Student;
import com.Jayesh.Studentservice.repositry.Repo;

@RestController
@RequestMapping("/student")
public class conteroller {

	@Autowired
	private Repo repo;
	
	@PostMapping("/save")
	public Student savestudent(@RequestBody Student student) {
		return repo.save(student);
	}
	
	@GetMapping("/All")
	public List<Student> getall(){
		return repo.findAll();
	}
	
	@GetMapping("/findbyid/{id}")
	public Student findbyid(@PathVariable int id) {
		Optional<Student>optional=repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	@GetMapping("/findbycollege/{id}")
	public List<Student> findbycollege(@PathVariable int id ) {
		return repo.findByCollegeid(id);
	}
}
