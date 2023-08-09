package com.ep.backend.entities;



import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long student_id;
	
	@Column(name = "Students_name")
	private String studentstName;
	
	@Column(nullable = false)
	private long students_number;
	 
	@Column(name = "Students_email_id")
	private String studentsEmailId;

	@Column(name = "Parents_name")
	private String parentsName;
	
	@Column(nullable = false)
	 private long parents_number;
	
	@Column(name = "Parents_email_id")
	private String parents_emailId;
	
	@CreationTimestamp
	private Date date;

	 @Column(length = 20)
	private String role;
	 
	private int grade;
	  
	private String password;
	
	
  //  private List<Course> courseList;
 
 /*@JsonManagedReference
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;
    
  //@OneToOne(cascade = CascadeType.ALL)
  	 private Course course;*/
  	 
}

