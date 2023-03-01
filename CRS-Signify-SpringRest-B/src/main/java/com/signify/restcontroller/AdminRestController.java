/**
 * 
 */
package com.signify.restcontroller;

import java.util.*;
import com.signify.bean.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.signify.service.AdminService;

/**
 * @author aksha
 *
 */

@RestController
public class AdminRestController {
	@Autowired
	private AdminService admin;
	private List<Student> studs;
	private List<Course> courses;
	private List<GradeCard> gc;
	/**
	 * 
	 * @return list of students 
	 */
	@RequestMapping(
			produces=MediaType.APPLICATION_JSON,
			method = RequestMethod.GET,
			value = "/viewUnapproved")
	@ResponseBody
	public ResponseEntity viewUnapproved() {
		studs = admin.viewUnapproveStudents();
		return new ResponseEntity(studs, HttpStatus.OK);
	}
	
	
	/**
	 * 
	 * @param param
	 * @return student has been approved or not 
	 */
	@RequestMapping(
			method = RequestMethod.POST,
			value = "/approveStudent")
	@ResponseBody
	public ResponseEntity approveStud(@RequestBody Map<String,String> param) {
		Integer id = Integer.parseInt(param.get("id"));
		boolean flag = admin.approveStudent(id);
		if(flag)
			return ResponseEntity.status(HttpStatus.OK).body("Approved Successfully");
		else 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Could not find Student with id "+id);
	}
	
	
	/**
	 * 
	 * @param param
	 * @return id of new admin 
	 */
	@RequestMapping(
			method = RequestMethod.POST,
			value = "/addAdmin")
	@ResponseBody
	public ResponseEntity<String> addAdmin(@RequestBody Map<String,String> param) {
		String name = param.get("name");
		String pass = param.get("pass");
		int id = admin.addAdmin(name, pass);
		if(id!=0)
			return ResponseEntity.status(HttpStatus.OK).body("Admin Added");
		else 
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("Could Not Create Admin!");
	}
	
	
	/**
	 * 
	 * @param param
	 * @return id of added professor
	 */
	@RequestMapping(
			method = RequestMethod.POST,
			value = "/addProf")
	@ResponseBody
	public ResponseEntity<String> addProfessor(@RequestBody Map<String,String> param) {
		String name = param.get("name");
		String pass = param.get("pass");
		String dep = param.get("dep");
		String des = param.get("des");
		int id = admin.addProfessor(name, pass, dep, des);
		if(id!=0)
			return ResponseEntity.status(HttpStatus.OK).body("Professor Added");
		else 
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("Could Not Create Professor!");
	}
	
	
	/**
	 * 
	 * @param param
	 * @return courses is added or not
	 */
	@RequestMapping(
			method = RequestMethod.POST,
			value = "/addCourse")
	@ResponseBody
	public Response addCourse(@RequestBody Map<String,String> param) {
		String coursename = param.get("coursename");
		int profid = Integer.parseInt(param.get("id"));
		boolean flag = admin.addCourse(coursename, profid);
		if(flag)
			return Response.status(200).entity("Course added Successfully!").build();
		else 
			return Response.status(404).entity("Professor or Course not Found!").build();
	}
	
	/**
	 * 
	 * @param param
	 * @return course is removed or not
	 */
	@RequestMapping(
			method = RequestMethod.POST,
			value = "/removeCourse")
	@ResponseBody
	public Response removeCourse(@RequestBody Map<String,String> param) {
		String coursename = param.get("coursename");
		boolean flag = admin.removeCourse(coursename);
		if(flag)
			return Response.status(200).entity("Removed course"+coursename).build();
		else 
			return Response.status(404).entity("Course "+coursename+" not found").build();
	}
	
	/**
	 * 
	 * @return list of courses
	 */
	@RequestMapping(
			produces=MediaType.APPLICATION_JSON,
			method = RequestMethod.GET,
			value = "/viewCourses")
	@ResponseBody
	public ResponseEntity viewCourses() {
		courses = admin.viewCourses();
		return new ResponseEntity(courses, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param param
	 * @return list of gradcard
	 */
	
	@RequestMapping(
			produces=MediaType.APPLICATION_JSON,
			method = RequestMethod.POST,
			value = "/viewGradeCard")
	@ResponseBody
	public ResponseEntity viewGradeCard(@RequestBody Map<String,String> param) {
		int id = Integer.parseInt(param.get("id"));
		gc = admin.generateReport(id);
		return new ResponseEntity(gc, HttpStatus.OK);
	}
}
