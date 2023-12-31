package com.ep.backend.dto;

import org.springframework.stereotype.Component;

import com.ep.backend.entities.Student;
@Component
public class EntityDtoConvertor {

		public StudentDto toStudDto(Student entity){
			StudentDto dto =new StudentDto();
			dto.setStudent_id(entity.getStudent_id());
			dto.setStudentstName(entity.getStudentstName());
			dto.setStudents_number(entity.getStudents_number());
			dto.setStudentsEmailId(entity.getStudentsEmailId());
			dto.setParentsName(entity.getParentsName());
			dto.setParents_number(entity.getParents_number());
			dto.setParents_emailId(entity.getParents_emailId());
			dto.setDate(entity.getDate());
			dto.setGrade(entity.getGrade());
			dto.setPassword("********");
			
			return dto;
		}
		
		public Student toStudentEntity(StudentDto dto) {
			Student entity = new Student();
			entity.setStudent_id(dto.getStudent_id());
			entity.setStudentstName(dto.getStudentstName());
			entity.setStudents_number(dto.getStudents_number());
			entity.setStudentsEmailId(dto.getStudentsEmailId());
			entity.setParentsName(dto.getParentsName());
			entity.setParents_number(dto.getParents_number());
			entity.setParents_emailId(dto.getParents_emailId());
			entity.setDate(dto.getDate());
			entity.setGrade(dto.getGrade());
			entity.setPassword(dto.getPassword());
			
			
			
			return entity;
			
		}
		/*	public Student toUserEntity(Credential dto) {
				Student entity = new Student ();
				
				entity.setStudents_emailId(dto.getEmail());
				entity.setStudents_number(dto.getMobileNo());
				entity.setPassword(dto.getPassword());
				
				return entity;		
			}
			*/
}
