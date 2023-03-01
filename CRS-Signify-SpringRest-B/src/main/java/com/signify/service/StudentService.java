/**
 * 
 */
package com.signify.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.signify.exception.*;
import com.signify.bean.Course;
import com.signify.bean.Student;
import com.signify.bean.User;
import com.signify.dao.StudentDAOImplementation;
import com.signify.dao.StudentDAOInterface;

/**
 * @author Naman
 *
 */
@Service
public class StudentService implements StudentInterface {
    @Autowired
	StudentDAOInterface studentDao;
    public int registerForStudent(String name,String password,String branch,int batch)
	{
		return studentDao.registerDAOStudent(name,password,branch, batch);
	}
	public void viewGradeCard()
	{
		System.out.println("Currently no grade cards are available");
	}
	public boolean isVacant(int c1id)
	{
		return studentDao.isDAOVacant(c1id);
	}
	public boolean isSemRegister(int sem,int id)
	{
		return studentDao.isSemDAORegister(sem,id);
	}
	public String semReg(int studid,int sem,String doj,int cid[])
	{
		return studentDao.semDAORegister(studid,sem,doj,cid);
	}
	public List<Course> viewCatalog()
	{
		List<Course>courses = new ArrayList<Course>();
		try
		{
			courses = studentDao.viewDAOCatalog();
		}
		catch(CourseNotFoundException ce)
		{
			
		}
		return courses;
	}
	public String addCourse(int studid,int cid)
	{
		String resp="";
		try
		{
			resp = studentDao.addDAOCourse(studid,cid);
			//System.out.println("resp from add course"+resp);
			System.out.println(resp);
			return resp;
		}
		catch(CourseFilledException ce)
		{
			
		}
//		catch(SixRegisteredCoursesException se)
//		{
//			
//		}
		catch(AlreadyRegisteredException ae)
		{
			
		}
		catch(NoSemesterRegisteration ne)
		{
			
		}
		finally {
			System.out.println("resp"+resp);
			return resp;
		}
		//return resp;
		
	}
	public String dropCourse(int studid,int cid)
	{
		return studentDao.dropDAOCourse(studid,cid);
	}
	public List<Course> myCatalog(int studid)
	{
		List<Course>courses = new ArrayList<Course>();  
		try
		{
			courses = studentDao.myDAOCatalog(studid);
		}
		catch(CourseNotFoundException ce)
		{
			
		}
		return courses;
	}
	public boolean isPaid(int studid, int semester) {
		if(studentDao.isDAOPaid(studid, semester)) {
			return true;
		}
		return false;
	}	
	public List<Course> feeCatalog(int studid, int semester,int total_fees[]) {
		List<Course>courses = new ArrayList<Course>();
		try {
			
			courses = studentDao.feeDAOCatalog(studid, semester,total_fees);
		} 
		catch (CourseNotFoundException e) {
			
		}
		return courses;
	}
	
	public String payFeeOnline(int ID,int semm,int pay_choice,int amount,String cardType,String bankName,int cardNumber,String cardName,int cvv,String expiry) {
		return studentDao.payDAOFeeOnline(ID,semm,pay_choice,amount,cardType,bankName,cardNumber,cardName,cvv,expiry);
		
	}
	public String payFee(int id,int sem,int pay,int amount)
	{
		return studentDao.payDAOFee(id, sem, pay, amount);
	}
}