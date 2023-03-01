package com.signify.restcontroller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.signify.bean.Course;
import com.signify.bean.Student;
import com.signify.service.StudentInterface;
import com.signify.service.StudentService;

@RestController
public class StudentRestController {
	
	@Autowired 
	private StudentService student;
	private List<Course> course;
	private List<Course> fee;
	
	/**
	 * 
	 * @param param
	 * @return student id after semester registeration
	 */
	@RequestMapping(
			produces=MediaType.APPLICATION_JSON,
			method = RequestMethod.POST,
			value = "/register")
	@ResponseBody
	public ResponseEntity login(@RequestBody Map<String,String> param) {
		String name = param.get("name");
		String password = param.get("password");
		String branch = param.get("branch");
		String batch = param.get("batch");
		int batch_1 = Integer.parseInt(batch);
		int user_id = student.registerForStudent(name, password, branch, batch_1);
		String resp = "Your user id is "+user_id+"";
		return new ResponseEntity(resp,HttpStatus.OK);
			
	}
	
	/**
	 * 
	 * @return list of courses
	 */
	@RequestMapping(
			produces=MediaType.APPLICATION_JSON,
			method = RequestMethod.GET,
			value= "/viewCatalog")
	@ResponseBody
	public ResponseEntity viewCatalog() {
		
		List<Course> coursee = new ArrayList<Course>();
		coursee = student.viewCatalog();
		return new ResponseEntity(coursee,HttpStatus.OK);
			
	}
	
	/**
	 * 
	 * @param id
	 * @param param
	 * @return status of student semester registeration
	 */
	@RequestMapping(
			produces=MediaType.APPLICATION_JSON,
			method = RequestMethod.POST,
			value= "/{id}/semreg")
	@ResponseBody
	public ResponseEntity semreg(@PathVariable("id") int id,@RequestBody Map<String,String> param) {
		String sem = param.get("sem");
		String doj = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		int[] arr = new int[6];
		String id1 = param.get("id1");
		String id2 = param.get("id2");
		String id3 = param.get("id3");
		String id4 = param.get("id4");
		String id5 = param.get("id5");
		String id6 = param.get("id6");
		int id_1 = Integer.parseInt(id1);
		int id_2 = Integer.parseInt(id2);
		int id_3 = Integer.parseInt(id3);
		int id_4 = Integer.parseInt(id4);
		int id_5 = Integer.parseInt(id5);
		int id_6 = Integer.parseInt(id6);
		arr[0] = id_1;
		arr[1] = id_2;
		arr[2] = id_3;
		arr[3] = id_4;
		arr[4] = id_5;
		arr[5] = id_6;
		int semm = Integer.parseInt(sem);
		System.out.println(doj);
		System.out.println("id"+id);
		System.out.println("sem"+sem);
		System.out.println("course"+arr);
		
		String resp = student.semReg(id, semm, doj, arr);
		return new ResponseEntity(resp,HttpStatus.OK);
			
	}
	/**
	 * 
	 * @param id
	 * @param param
	 * @return status of course addition 
	 */
	@RequestMapping(
			produces=MediaType.APPLICATION_JSON,
			method = RequestMethod.POST,
			value= "/{id}/addCourse")
	@ResponseBody
	public ResponseEntity addCourse(@PathVariable("id") int id,@RequestBody Map<String,String> param) {
		
		String c_id = param.get("c_id");
		int c_idd = Integer.parseInt(c_id);
		String resp = student.addCourse(id, c_idd);
		System.out.println(resp);
		return new ResponseEntity(resp,HttpStatus.OK);
			
	}
	
	/**
	 * 
	 * @param id
	 * @param param
	 * @return status of course removal
	 */
	@RequestMapping(
			produces=MediaType.APPLICATION_JSON,
			method = RequestMethod.POST,
			value= "/{id}/removeCourse")
	@ResponseBody
	public ResponseEntity removeCourse(@PathVariable("id") int id,@RequestBody Map<String,String> param) {
		String c_id = param.get("c_id");
		int c_idd = Integer.parseInt(c_id);
		String resp = student.dropCourse(id, c_idd);
		return new ResponseEntity(resp,HttpStatus.OK);
			
	}
	
	/**
	 * 
	 * @param id
	 * @return list of courses in my catalog
	 */
	@RequestMapping(
			produces=MediaType.APPLICATION_JSON,
			method = RequestMethod.POST,
			value= "/{id}/myCatalog")
	@ResponseBody
	public ResponseEntity myCatalog(@PathVariable("id") int id) {
		course = student.myCatalog(id);
		return new ResponseEntity(course,HttpStatus.OK);
			
	}
	
	/**
	 * 
	 * @param id
	 * @param param
	 * @return status of registered semester
	 */
	@RequestMapping(
			produces=MediaType.APPLICATION_JSON,
			method = RequestMethod.POST,
			value= "/{id}/isSemRegister")
	@ResponseBody
	public ResponseEntity isSemRegister(@PathVariable("id") int id,@RequestBody Map<String,String> param) {
		String sem = param.get("sem");
		int semm = Integer.parseInt(sem);
		boolean flag = student.isSemRegister(id, semm);
		String resp="";
		if(flag) {
			resp="True";
		}else {
			resp="False";
		}
		return new ResponseEntity(resp,HttpStatus.OK);
			
	}
	
	/**
	 * 
	 * @param param
	 * @return status of seats availablity
	 */
	@RequestMapping(
			produces=MediaType.APPLICATION_JSON,
			method = RequestMethod.POST,
			value= "/isVacant")
	@ResponseBody
	public ResponseEntity isVacant(@RequestBody Map<String,String> param) {
		String c_id = param.get("c_id");
		int cid = Integer.parseInt(c_id);
		boolean flag = student.isVacant(cid);
		String resp="";
		if(flag) {
			resp="Is vacant";
		}else {
			resp="Not vacant";
		}
		
		return new ResponseEntity(resp,HttpStatus.OK);
			
	}
	
	/**
	 * 
	 * @param id
	 * @param param
	 * @return status of fee
	 */
	@RequestMapping(
			produces=MediaType.APPLICATION_JSON,
			method = RequestMethod.POST,
			value= "{id}/isPaid")
	@ResponseBody
	public ResponseEntity isPaid(@PathVariable("id") int id,@RequestBody Map<String,String> param) {
		String sem = param.get("sem");
		int semm = Integer.parseInt(sem);
		boolean flag = student.isPaid(id, semm);
		String resp="";
		if(flag) {
			resp="Is Paid";
		}else {
			resp="Not Paid";
		}
		
		return new ResponseEntity(resp,HttpStatus.OK);
			
	}
	
	/**
	 * 
	 * @param id
	 * @param param
	 * @return status fee catalog
	 */
	@RequestMapping(
			produces=MediaType.APPLICATION_JSON,
			method = RequestMethod.POST,
			value= "{id}/viewFeeCatalog")
	@ResponseBody
	public ResponseEntity viewFeeCatalog(@PathVariable("id") int id,@RequestBody Map<String,String> param) {
	    String sem = param.get("sem");
	    
		int semm = Integer.parseInt(sem);
		int[] totalfee = new int[5];
		fee = student.feeCatalog(id, semm, totalfee);
		boolean flag = student.isPaid(id, semm);
		
		
		return new ResponseEntity(fee,HttpStatus.OK);
			
	}
	
	/**
	 * 
	 * @param id
	 * @param param
	 * @return status of fee pay
	 */
	@RequestMapping(
			produces=MediaType.APPLICATION_JSON,
			method = RequestMethod.POST,
			value= "{id}/payFee/")
	@ResponseBody
	public ResponseEntity payFee(@PathVariable("id") int id,@RequestBody Map<String,String> param) {
	    String sem = param.get("sem");
	    String mode = param.get("mode");
	    String amt = param.get("amt");
		int semm = Integer.parseInt(sem);
		int modee = Integer.parseInt(mode);
		int amtt = Integer.parseInt(amt);
		
		String resp = student.payFee(id, semm, modee, amtt);
		
		
		return new ResponseEntity(resp,HttpStatus.OK);
			
	}
	
	/**
	 * 
	 * @param id
	 * @param param
	 * @return status of online fee pay
	 */
	@RequestMapping(
			produces=MediaType.APPLICATION_JSON,
			method = RequestMethod.POST,
			value= "{id}/payOnlineFee")
	@ResponseBody
	public ResponseEntity payOnlineFee(@PathVariable("id") int id,@RequestBody Map<String,String> param) {
	    String sem = param.get("sem");
	    String mode = param.get("mode");
	    String amt = param.get("amt");
		int semm = Integer.parseInt(sem);
		int modee = Integer.parseInt(mode);
		int amtt = Integer.parseInt(amt);
		String pay_choice = param.get("pay_choice");
		String cardType = param.get("cardType");
		String bankName = param.get("bankname");
		
		String cardNumber = param.get("cardNumber");
		String cardName = param.get("cardName");
		String cvv = param.get("cvv");
		String expiry = param.get("expiry");
		int pay_choicee = Integer.parseInt(pay_choice);
		int card_no = Integer.parseInt(cardNumber);
		int cvvv = Integer.parseInt(cvv);
		String resp = student.payFeeOnline(id, semm, pay_choicee, amtt, cardType, bankName, card_no, cardName, cvvv, expiry);
		return new ResponseEntity(resp,HttpStatus.OK);
		
	}
		
			
	
	
	
}