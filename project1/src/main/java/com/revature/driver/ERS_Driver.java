package com.revature.driver;

import java.sql.Timestamp;
import java.time.Instant;

import com.revature.beans.Reimbursement;
import com.revature.beans.User;
import com.revature.dao.ReimbursementDaoDB;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoDB;
import org.apache.log4j.Logger;

public class ERS_Driver {

	public final static Logger logger = Logger.getLogger(ERS_Driver.class);	
	
	public static void main(String[] args) {
		Reimbursement rtemp = new Reimbursement();
		User utemp = new User();
		ReimbursementDaoDB rDao = new ReimbursementDaoDB();
		UserDao udao = new UserDaoDB();
		
		
		utemp.setId(1);
		utemp.setEmail("r@gmail.com");
		utemp.setFirstName("r");
		utemp.setLastName("a");
		utemp.setPassword("tempPassword");
		utemp.setUsername("tempEmp");
		utemp.setUserRoleId(1);
		udao.addUser(utemp);
		
		utemp.setId(2);
		utemp.setEmail("te@gmail.com");
		utemp.setFirstName("t");
		utemp.setLastName("e");
		utemp.setPassword("tempPassword");
		utemp.setUsername("tempMan");
		utemp.setUserRoleId(2);
		udao.addUser(utemp);
		
		rtemp.setAmount(150.00);
		rtemp.setAuthorId(1);
		rtemp.setDescription("this is necesaary");
		rtemp.setReimbId(1);
		rtemp.setSubmitted(Timestamp.from(Instant.now()));
		rtemp.setStatusid(1);
		rtemp.setTypeId(1);
		rDao.addReimbursement(rtemp);
		
		
//		rDao.removeReimbursement(rtemp);
//		udao.removeUser(utemp);
	
		
		
	}

}
