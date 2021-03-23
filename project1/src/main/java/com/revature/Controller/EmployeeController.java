package com.revature.Controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbursement;
import com.revature.beans.User;
import com.revature.dao.ReimbursementDaoDB;
import com.revature.dao.UserDaoDB;
import com.revature.exceptions.UnauthorizedException;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;

public class EmployeeController {
	static UserDaoDB udb = new UserDaoDB();
	static ReimbursementDaoDB  rdb = new ReimbursementDaoDB();
	static UserService uService = new UserService(udb,rdb);
	static ReimbursementService rService = new ReimbursementService(udb,rdb);
	static Logger logger = Logger.getLogger(EmployeeController.class);
	
	public static String home(HttpServletRequest req) {
		return "resources/html/employeeHome.html";
	}
	
	public static void getAllReimbursements(HttpServletRequest req, HttpServletResponse res) {
		if(req.getSession(false) == null) {
			try {
				logger.debug("Tried to submit with no user logged in");
				res.sendRedirect("/project1/resources/html/login.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		List<Reimbursement> currentReimbursements = rService.viewAllReimbursements();
		try {
			res.getWriter().write(new ObjectMapper().writeValueAsString(currentReimbursements));
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	
	public static void updateReimbursements(HttpServletRequest req) {
		List<Reimbursement> currentReimbursements = rService.viewAllReimbursements();
		User currentUser =  (User) req.getSession().getAttribute("loggedUser");
		for(Reimbursement r:currentReimbursements) {
			if(r.getReimbId().equals(Integer.parseInt(req.getParameter("reimbursementID")))){
				if(Integer.parseInt(req.getParameter("newReimbursementStatus")) == 2) {
					rService.approveDenyReimbursement(r, true, currentUser.getId());
				}
				else {
					rService.approveDenyReimbursement(r, false, currentUser.getId());
				}
			}
		}
	}
}
