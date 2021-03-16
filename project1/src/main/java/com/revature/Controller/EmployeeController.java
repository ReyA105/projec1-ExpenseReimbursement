package com.revature.Controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDaoDB;
import com.revature.dao.UserDaoDB;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;

public class EmployeeController {
	static UserDaoDB udb = new UserDaoDB();
	static ReimbursementDaoDB  rdb = new ReimbursementDaoDB();
	static UserService uService = new UserService(udb,rdb);
	static ReimbursementService rService = new ReimbursementService(udb,rdb);
	
	
	public static String home(HttpServletRequest req) {
		return "resources/html/employeeHome.html";
	}
	
	public static void getAllReimbursements(HttpServletRequest req, HttpServletResponse res) {
		List<Reimbursement> currentReimbursements = rService.viewAllReimbursements();
		try {
			res.getWriter().write(new ObjectMapper().writeValueAsString(currentReimbursements));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
