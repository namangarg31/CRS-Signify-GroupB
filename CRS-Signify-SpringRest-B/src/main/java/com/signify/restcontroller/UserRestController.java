/**
 * 
 */
package com.signify.restcontroller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.signify.bean.Customer;
import com.signify.bean.User;
import com.signify.service.UserInterface;
import com.signify.service.UserService;
import org.springframework.http.ResponseEntity;

/**
 * @author aksha
 *
 */


@RestController
public class UserRestController {
	@Autowired
	private UserService user;
	
	/**
	 * 
	 * @param param
	 * @return status for login
	 */
	@RequestMapping(
			method = RequestMethod.POST,
			value = "/login")
	@ResponseBody
	public ResponseEntity<String> login(@RequestBody Map<String,String> param) {
		int id = Integer.parseInt(param.get("id"));
		String pass = param.get("pass");
		String role = param.get("role");
			if(user.userLogin(id, pass, role)) {
				return ResponseEntity.status(HttpStatus.OK).body("Logged In as "+role);
			}
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong Credentials");
			
	}
	
	/**
	 * 
	 * @param param
	 * @return status for update password
	 */
	@RequestMapping(
			method = RequestMethod.POST,
			value = "/updatePass")
	@ResponseBody
	public ResponseEntity<String> updatePass(@RequestBody Map<String,String> param) {
		int id = Integer.parseInt(param.get("id"));
		String oldpass = param.get("oldpass");
		String newpass = param.get("newpass");
		user.updatePassword(id, oldpass, newpass);
		return ResponseEntity.status(HttpStatus.CREATED).body("Password Changed");
			
	}
}
