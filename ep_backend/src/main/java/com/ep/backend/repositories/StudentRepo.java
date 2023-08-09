package com.ep.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ep.backend.entities.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{
	
	Student findBystudentsEmailId(String email);
	
	 Optional<Student> findOneBystudentsEmailIdAndPassword(String email, String password);
	
}
