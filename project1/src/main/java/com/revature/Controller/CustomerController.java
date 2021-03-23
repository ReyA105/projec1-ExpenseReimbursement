package com.revature.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementDaoDB;
import com.revature.dao.UserDaoDB;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;
import com.revature.beans.*;

public class CustomerController {
	static UserDaoDB udb = new UserDaoDB();
	static ReimbursementDaoDB  rdb = new ReimbursementDaoDB();
	static UserService uService = new UserService(udb,rdb);
	static ReimbursementService rService = new ReimbursementService(udb,rdb);
	
	public static String home(HttpServletRequest req) {
		return "resources/html/customerHome.html";
	}
	
	public static void reimbursementFinder(HttpServletRequest req, HttpServletResponse res) {
		User currentUser =  (User) req.getSession().getAttribute("loggedUser");
		List<Reimbursement> currentReimbursements = rService.viewEmployeeReimbursements(currentUser.getId());
		
		try {
			res.getWriter().write(new ObjectMapper().writeValueAsString(currentReimbursements));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	 
	public static void addReimbursement(HttpServletRequest req){
		User currentUser =  (User) req.getSession().getAttribute("loggedUser");
		Reimbursement newReimb = new Reimbursement();
		newReimb.setAuthorId(currentUser.getId());
		newReimb.setAmount(Double.parseDouble(req.getParameter("amount")));
		newReimb.setDescription(req.getParameter("description"));
		newReimb.setTypeId(Integer.parseInt(req.getParameter("reimbursementType")));
		System.out.println(newReimb);
		System.out.println(req.getParameter("reimbursementType"));
		
		rService.addNewReimbursement(newReimb);
	}
}
