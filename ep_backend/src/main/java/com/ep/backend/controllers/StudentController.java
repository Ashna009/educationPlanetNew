package com.ep.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.ep.backend.dto.Credential;
import com.ep.backend.dto.LoginMesage;
import com.ep.backend.dto.StudentDto;

import com.ep.backend.services.Impl.ServiceImpl;
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class StudentController {
	 @Autowired
	    private ServiceImpl studentService;
	 

	    @PostMapping(path = "/login")
	    public ResponseEntity<?> loginEmployee(@RequestBody StudentDto studentDto)
	    {
	        LoginMesage loginResponse = studentService.loginEmployee(studentDto);
	        return ResponseEntity.ok(loginResponse);
	    }

	 @PostMapping("/register")
	    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto) {
	        StudentDto savedStudent = studentService.saveStudent(studentDto);
	        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
	    }

	    @PutMapping("/{studentId}")
	    public ResponseEntity<StudentDto> updateStudent(@PathVariable("studentId") long studentId,
	                                                    @RequestBody StudentDto studentDto) {
	        studentDto.setStudent_id(studentId);
	        StudentDto updatedStudent = studentService.updateStudent(studentDto);
	        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
	    }

	    @DeleteMapping("/{studentId}")
	    public ResponseEntity<Void> deleteStudent(@PathVariable("studentId") long studentId) {
	        studentService.deleteStudent(studentId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    @GetMapping("/{email}")
	    public ResponseEntity<StudentDto> findStudentByEmail(@PathVariable("email") String email) {
	        StudentDto studentDto = studentService.findStudentByEmail(email);
	        return new ResponseEntity<>(studentDto, HttpStatus.OK);
	    }

	    @GetMapping
	    public ResponseEntity<List<StudentDto>> getAllStudents() {
	        List<StudentDto> students = studentService.getAllStudents();
	        return new ResponseEntity<>(students, HttpStatus.OK);
	    }

	    @PostMapping("/reset-password")
	    public ResponseEntity<Void> resetPassword(@RequestBody Credential credentials) {
	        studentService.resetPassword(credentials);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
}
