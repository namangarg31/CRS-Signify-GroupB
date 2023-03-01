/**
 * 
 */
package com.signify.service;

import java.sql.ResultSet;
import java.util.*;

import org.springframework.stereotype.Service;

import com.signify.bean.*;
import com.signify.dao.AdminDAOImplementation;
import com.signify.dao.AdminDAOInterface;
import com.signify.exception.CourseNotFoundException;
import com.signify.exception.ProfessorNotFoundException;
import com.signify.exception.StudentNotFoundForApprovalException;

/**
 * @author asus
 *
 */

@Service
public class AdminService implements AdminInterface{
	
	AdminDAOInterface ad = new AdminDAOImplementation();
	public List<Student> viewUnapproveStudents()
	{
		return ad.viewDAOUnapprove();
	}
	public boolean approveStudent(int id) {
	
		return ad.approveDAOStudent(id);
	}
	public int addAdmin(String name,String pass) 
	{
		return ad.addDAOAdmin(name,pass);
	}
	public boolean addCourse(String coursename,int profid)
	{
		return ad.addDAOCourse(coursename, profid);
	}
	public boolean removeCourse(String coursename)
	{
		return ad.removeDAOCourse(coursename);	
	}
	public List<Course> viewCourses()
	{
		List<Course>courses = null; 
		try
		{
			courses = ad.viewDAOCourses();
		}
		catch(CourseNotFoundException ce)
		{
			
		}
		return courses;
	}
	public int addProfessor(String name,String pass,String depart,String des)
	{
		return ad.addDAOProfessor(name,pass,depart,des);
	}
	public List<GradeCard> generateReport(int studid)
	{
		return ad.generateDAOReport(studid);
	}
}