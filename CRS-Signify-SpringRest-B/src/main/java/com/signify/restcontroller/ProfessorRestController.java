/** 
 * 
 */
package com.signify.restcontroller;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.signify.bean.*;
import com.signify.service.ProfessorService;

/**
 * @author aksha
 *
 */

@RestController
public class ProfessorRestController {
	
	@Autowired
	private ProfessorService prof;
	private List<Student> studs;
	
	/**
	 * 
	 * @param param
	 * @return list of enrolled students
	 */
	@RequestMapping(
			produces=MediaType.APPLICATION_JSON,
			method = RequestMethod.POST,
			value = "/viewEnrolledStudents")
	@ResponseBody
	public ResponseEntity viewEnrolledStudents(
			@RequestBody Map<String,String> param
			) {
		int id = Integer.parseInt(param.get("id"));
		studs = prof.viewEnrolledStudents(id);
		return new ResponseEntity(studs, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param param
	 * @return status of grade addition 
	 */
	@RequestMapping(
			method=RequestMethod.POST,
			value="/addGrade")
	@ResponseBody
	public ResponseEntity<String> addGrades(@RequestBody Map<String,String> param){
		int profid = Integer.parseInt(param.get("profid"));
		int studid = Integer.parseInt(param.get("studid"));
		String grade = param.get("grade");
		prof.addGrade(profid, studid, grade);
		return ResponseEntity.status(200).body("Grade Added Successfully!");
	}
}
