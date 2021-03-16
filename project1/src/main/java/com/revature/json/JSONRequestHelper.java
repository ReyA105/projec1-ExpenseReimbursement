package com.revature.json;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.Controller.CustomerController;
import com.revature.Controller.EmployeeController;




public class JSONRequestHelper {
	
	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException,
	IOException{
		if(req.getRequestURI().equals("/project1/PastReimbursements.json"))
			CustomerController.reimbursementFinder(req, res);
		if(req.getRequestURI().equals("/project1/AllReimbursements.json"))
			EmployeeController.getAllReimbursements(req,res);
	}
}
