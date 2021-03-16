package com.revature.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.revature.beans.User;
import com.revature.beans.UserRole;
import com.revature.beans.UserRole.UserRoleID;
import com.revature.dao.ReimbursementDaoDB;
import com.revature.dao.UserDaoDB;
import com.revature.exceptions.InvalidCredentialsException;
import com.revature.services.UserService;

public class LoginController {
	static UserDaoDB udb = new UserDaoDB();
	static ReimbursementDaoDB  rdb = new ReimbursementDaoDB();
	static UserService uService = new UserService(udb,rdb);
	
	
	public static String login(HttpServletRequest req) {
		if(!req.getMethod().equals("POST")) {
			return "resources/html/home.html";
		}
		req.getSession().invalidate();
		User newUser = new User();
		
		try {
			newUser = uService.login(req.getParameter("username"),  req.getParameter("password"));
			if(newUser == null)
				throw new InvalidCredentialsException();
		}catch(InvalidCredentialsException e) {
			return "resources/html/IncorrectCredentials.html";
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("loggedUser", newUser);
		
		if(UserRole.getUserRoleID(newUser.getUserRoleId()) == UserRoleID.EMPLOYEE) {
			return "/Customer/home";
		}else {
			return "/Employee/home";
		}
		
	}
	
	
}
