package com.Jayesh.Studentservice.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Jayesh.Studentservice.Entity.Student;

@Repository
public interface Repo extends JpaRepository<Student, Integer> {

	List<Student> findByCollegeid(int id);

}
