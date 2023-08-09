package com.ep.backend.services.Impl;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ep.backend.dto.Credential;
import com.ep.backend.dto.EntityDtoConvertor;
import com.ep.backend.dto.LoginMesage;
import com.ep.backend.dto.StudentDto;
import com.ep.backend.entities.Student;
import com.ep.backend.repositories.StudentRepo;

import jakarta.transaction.Transactional;
@Service
@Transactional
public  class ServiceImpl implements Service {
	@Autowired
    private StudentRepo studentRepository;
	@Autowired
    private EntityDtoConvertor entityDtoConvertor;
	@Autowired
    private  PasswordEncoder passwordEncoder;
	
	
	
	  
	    public LoginMesage  loginEmployee(StudentDto studentDto) {
	        String msg = "";
	        Student  student =  studentRepository.findBystudentsEmailId(studentDto.getStudentsEmailId());
	        if ( student != null) {
	            String password = studentDto.getPassword();
	            String encodedPassword =  student.getPassword();
	            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
	            if (isPwdRight) {
	                Optional< Student> employee =studentRepository.findOneBystudentsEmailIdAndPassword(studentDto.getStudentsEmailId(), encodedPassword);
	                if (employee.isPresent()) {
	                    return new LoginMesage("Login Success", true);
	                } else {
	                    return new LoginMesage("Login Failed", false);
	                }
	            } else {
	                return new LoginMesage("password Not Match", false);
	            }
	        }else {
	            return new LoginMesage("Email not exits", false);
	        }
	    }
	
	
	    public StudentDto saveStudent(StudentDto studentDto) {
	        String encodedPassword = passwordEncoder.encode(studentDto.getPassword());
	        studentDto.setPassword(encodedPassword);

	        Student student = entityDtoConvertor.toStudentEntity(studentDto);
	        Student savedStudent = studentRepository.save(student);

	        return entityDtoConvertor.toStudDto(savedStudent);
	    }


	    public StudentDto updateStudent(StudentDto studentDto) {
	        // Assuming student_id is already set in studentDto
	        Student existingStudent = studentRepository.findById(studentDto.getStudent_id())
	                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

	        // Update student fields
	        existingStudent.setStudentstName(studentDto.getStudentstName());
	        existingStudent.setStudents_number(studentDto.getStudents_number());
	        existingStudent.setStudentsEmailId(studentDto.getStudentsEmailId());
	        existingStudent.setParentsName(studentDto.getParentsName());
	        existingStudent.setParents_number(studentDto.getParents_number());
	        existingStudent.setParents_emailId(studentDto.getParents_emailId());
	        existingStudent.setDate(studentDto.getDate());
	        existingStudent.setGrade(studentDto.getGrade());

	        Student updatedStudent = studentRepository.save(existingStudent);

	        return entityDtoConvertor.toStudDto(updatedStudent);
	    }


	    public void deleteStudent(long studentId) {
	        studentRepository.deleteById(studentId);
	    }


	    public StudentDto findStudentByEmail(String email) {
	        Student student = studentRepository.findBystudentsEmailId(email);
	        return (student != null) ? entityDtoConvertor.toStudDto(student) : null;
	    }


	    public List<StudentDto> getAllStudents() {
	        List<Student> students = studentRepository.findAll();
	        return students.stream().map(entityDtoConvertor::toStudDto).collect(Collectors.toList());
	    }


	    public void resetPassword(Credential credentials) {
	        String email = credentials.getEmail();
	        String newPassword = credentials.getPassword();
	        String encodedPassword = passwordEncoder.encode(newPassword);

	        Student student = studentRepository.findBystudentsEmailId(email);
	        if (student != null) {
	            student.setPassword(encodedPassword);
	            studentRepository.save(student);
	        } else {
	            throw new IllegalArgumentException("Student not found with email: " + email);
	        }
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Class<? extends Annotation> annotationType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String value() {
		// TODO Auto-generated method stub
		return null;
	}

	  
	


    
 
	
}
