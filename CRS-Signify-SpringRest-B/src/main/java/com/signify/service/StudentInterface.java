package com.signify.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.signify.bean.Course;
import com.signify.bean.Student;

public interface StudentInterface {

	
	
	public int registerForStudent(String name,String password,String branch,int batch);//Done
	public List<Course> viewCatalog();//Done
	public boolean isVacant(int c1id);//Done
	public boolean isSemRegister(int sem,int id);//Done
	public String semReg(int studid,int sem,String doj,int cid[]);//Done
	public String addCourse(int studid,int cid);//Done
	public String dropCourse(int studid,int cid);//Done
	public List<Course> myCatalog(int studid);//Done
	public boolean isPaid(int studid, int semester);//Done
	public List<Course> feeCatalog(int studid, int semester,int total_fees[]);//Done
	public String payFee(int studid, int sem, int mode, int amt);
	public String payFeeOnline(int ID,int semm,int pay_choice,int amount,String cardType,String bankName,int cardNumber,String cardName,int cvv,String expiry);
}