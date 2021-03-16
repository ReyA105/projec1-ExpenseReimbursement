package com.revature.services;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.revature.beans.Reimbursement;
import com.revature.beans.ReimbursementStatus;
import com.revature.beans.ReimbursementType;
import com.revature.beans.User;
import com.revature.beans.UserRole;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoDB;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoDB;
//import com.revature.exceptions.InvalidCredentialsException;
import com.revature.exceptions.UnauthorizedException;
import com.revature.utils.SessionCache;

public class ReimbursementService {
	UserDao userDao;
	ReimbursementDao reimbDao;

	public ReimbursementService(UserDaoDB udao, ReimbursementDaoDB rdao) {
		this.userDao = udao;
		this.reimbDao = rdao;
	}
	// approveDenyReimbursement

	public boolean approveDenyReimbursement(Reimbursement reimb, boolean approval, int resolverID) {
		Optional<User> opt = SessionCache.getCurrentUser();
		User currentUser = opt.get();

		if (UserRole.getUserRoleID(currentUser.getUserRoleId()) == UserRole.UserRoleID.EMPLOYEE)
			throw new UnauthorizedException();

		reimb.setResolverid(resolverID);
		reimb.setResolved(Timestamp.from(Instant.now().truncatedTo(ChronoUnit.MINUTES)));
		reimbDao.updateReimbursement(reimb);

		return true;
	}

	// viewAll
	public List<Reimbursement> viewAllReimbursements() {
		List<Reimbursement> allReimbursements = new ArrayList<Reimbursement>();
		allReimbursements = reimbDao.getAllReimbursement();
	
		return allReimbursements;
	}

	public List<Reimbursement> viewEmployeeReimbursements(int userid) {

		List<Reimbursement> employeeReimbursements = new ArrayList<Reimbursement>();
		employeeReimbursements = reimbDao.getReimbursementbyAuthor(userid);
		return employeeReimbursements;
	}

	// add new reimbursement
	public void addNewReimbursement(Reimbursement newReimb) {
		List<Reimbursement> reimbList = new ArrayList<Reimbursement>();
		reimbList = reimbDao.getAllReimbursement();
		newReimb.setReimbId(reimbList.size() + 1);
		newReimb.setSubmitted(Timestamp.from(Instant.now().truncatedTo(ChronoUnit.MINUTES)));
		newReimb.setStatusid(1);
		reimbDao.addReimbursement(newReimb);

	}
}
