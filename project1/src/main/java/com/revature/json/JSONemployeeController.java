package com.revature.json;

import com.revature.dao.ReimbursementDaoDB;
import com.revature.dao.UserDaoDB;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;

public class JSONemployeeController {
	UserDaoDB udb = new UserDaoDB();
	ReimbursementDaoDB  rdb = new ReimbursementDaoDB();
	UserService uService = new UserService(udb,rdb);
	ReimbursementService rService = new ReimbursementService(udb,rdb);
}
