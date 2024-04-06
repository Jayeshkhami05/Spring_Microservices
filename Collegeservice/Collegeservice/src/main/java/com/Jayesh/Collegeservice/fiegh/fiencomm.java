package com.Jayesh.Collegeservice.fiegh;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Jayesh.Collegeservice.entity.Student;

@FeignClient(name="Studentservice")
public interface fiencomm {

	@GetMapping("/student/All")
	public List<Student> getall();
	
	@GetMapping("/student/findbyid/{id}")
	public Student findbyid(@PathVariable int id);
	
	@GetMapping("/student/findbycollege/{id}")
	public List<Student> findbycollege(@PathVariable int id );
	
	
}
