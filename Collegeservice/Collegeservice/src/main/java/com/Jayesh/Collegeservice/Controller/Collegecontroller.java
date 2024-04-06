package com.Jayesh.Collegeservice.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jayesh.Collegeservice.entity.College;
import com.Jayesh.Collegeservice.entity.Student;
import com.Jayesh.Collegeservice.fiegh.fiencomm;
import com.Jayesh.Collegeservice.repositry.Repo;

@RestController
@RequestMapping("/college")
public class Collegecontroller {

	@Autowired
	private fiencomm fiencomm;

	@Autowired
	private Repo repo;
	
	@PostMapping("/save")
	public College saveCollege(@RequestBody College college) {
		return repo.save(college);
	}
	
	@GetMapping("/All")
	public List<College> allCollege(){
		List<College> listcollege=repo.findAll();
		return listcollege.stream().map(college->{
			List<Student> liststudent= fiencomm.findbycollege(college.getId());
			college.setStudents(liststudent);
			return college;
		}).toList();
	}
	
	@GetMapping("/getByCollegeid/{id}")
	public College getByCollegeid(@PathVariable int id) {
		Optional<College> optional=repo.findById(id);
		if(optional.isPresent()) {
			College college=optional.get();
			List<Student> liststudent= fiencomm.findbycollege(id);
			college.setStudents(liststudent);
			return college;
		}
		return null;
	}
}
