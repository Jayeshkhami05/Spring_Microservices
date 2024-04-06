package com.Jayesh.Collegeservice.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Jayesh.Collegeservice.entity.College;

@Repository
public interface Repo extends JpaRepository<College, Integer> {

}
