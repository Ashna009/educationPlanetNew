package com.ep.backend.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDto {
	private long student_id;
	
	
	private String studentstName;
	
	
	private long students_number;
	 
	
	private String studentsEmailId;


	private String parentsName;
	
	
    private long parents_number;
	
	
	private String parents_emailId;
	
	
	private Date date;
	
	private int grade;
	  
    private String password;
	 

}
