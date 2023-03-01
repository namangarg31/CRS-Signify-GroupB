/**
 * 
 */
package com.signify.service;

import java.sql.SQLException;
import java.util.*;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.signify.bean.Student;
import com.signify.bean.User;
import com.signify.dao.StudentDAOImplementation;
import com.signify.dao.StudentDAOInterface;
import com.signify.dao.UserDAOImplementation;
import com.signify.dao.UserDAOInterface;
import com.signify.exception.UserNotFoundException;

/**
 * @author Naman
 *
 */

@Service
public class UserService implements UserInterface{
	 
	 UserDAOInterface userDao = new UserDAOImplementation();
	 public boolean userLogin(int userID,String password,String role) 
		{
		 boolean result = false;
		    try {
		    	result = userDao.validate(userID,password,role);
		    	return result;
		    }
		    catch(UserNotFoundException ex) {
		    	
		    }
		    return result;
		}
	 public void updatePassword(int id,String oldpass,String newpass)
	 {
		 try {
			userDao.updateDAOPassword(id,oldpass,newpass);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
	 }
}