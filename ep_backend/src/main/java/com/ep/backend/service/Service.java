package com.ep.backend.service;

import java.util.List;

import com.ep.backend.dto.Credential;
import com.ep.backend.dto.LoginMesage;
import com.ep.backend.dto.StudentDto;

public interface Service {
	 StudentDto saveStudent(StudentDto studentDto);

	    StudentDto updateStudent(StudentDto studentDto);

	    void deleteStudent(long studentId);

	    StudentDto findStudentByEmail(String email);

	    List<StudentDto> getAllStudents();

	    void resetPassword(Credential credentials);
	    
	    LoginMesage loginEmployee(StudentDto studentDto);
}
