package com.relation.manytomany.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relation.manytomany.service.ServiceClass;
import com.relation.manytomany.service.StudentDto;
import com.relation.models.Course;
import com.relation.models.Student;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/studentcourse")
@Tag(name="Student and Course Controller",description = "Student and Course management API")
public class StudentCourseController {
	@Autowired
	ServiceClass service;
	
	
	@GetMapping("/allstudent")
	@Operation(summary = "All Students",description = "Get All Student Details")
	public List<Student> findAllStudent(){
		return service.findAllStudents();
	}
	
	@GetMapping("/allcourse")
	@Operation(summary = "All Course",description = "Get all course details")
	public List<Course> findAllCourse(){
		
		return service.findAllCourse();
	}
	
	@GetMapping("/course/{cid}")
	@Operation(summary = "Course By ID", description = "Get course details by course ID")
	public Course courseById(@PathVariable int cid)
	{
		return service.findCourseById(cid);
	}
	
	@GetMapping("/student/{sid}")
	@Operation(summary = "Student By ID",description = "Get Student details by Student ID")
	public Student studentById(@PathVariable int sid)
	{
		return service.findStudentById(sid);
	}
	
	@PostMapping(path="/student")
	@Operation(summary = "Insert new Student",description = "Insert new Student into DB")
	public Student addStudent(@RequestBody Student student) {
		return service.saveStudent(student);
	}
	
	@PostMapping(path="/course")
	@Operation(summary = "Insert new Course",description = "Insert new Course into DB")
	public Course addCourse(@RequestBody Course course)
	{
		return service.newCourse(course);
	}
	
	@Operation(summary = "Update Student details",description = "Update Student Details")
	@PutMapping(path="/student")
	public Student updateStudent(@RequestBody StudentDto student)
	{
		return service.updateStudent(student);
	}
	
	@PutMapping(path="/course")
	@Operation(summary = "Update Course details",description = "Update Course Details")
	public Course updateCourse(@RequestBody Course course)
	{
		return service.updateCourse(course);
	}
	
	@DeleteMapping(path="/student/{sid}")
	@Operation(summary = "Delete Student by ID",description = "Delete Student details by Student ID")
	public void deleteStudent(@PathVariable int sid)
	{
		service.deleteStudent(sid);
	}
}
