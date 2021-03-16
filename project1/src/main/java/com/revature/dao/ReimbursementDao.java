package com.revature.dao;

import java.util.List;

import com.revature.beans.Reimbursement;

public interface ReimbursementDao {

	/**
	 * Inserts a new Reimbursement into the persistence layer
	 * @param Reimbursement object to insert
	 * @return the newly added Reimbursement object
	 */
	public Reimbursement addReimbursement(Reimbursement reimb);
	
	/**
	 * Retrieves a Reimbursement by employeeId
	 * @param employeeId the id to search by
	 * @return the Reimbursement object
	 */
	
	public List<Reimbursement> getReimbursementbyAuthor(Integer employeeId);
	
	/**
	 * Retrieves a Reimbursement by reimbID
	 * @param reimbID the id to search by
	 * @return the Reimbursement object
	 */
	
	public Reimbursement getReimbursementbyID(Integer reimbID);
	/**
	 * Retrieves all Reimbursements
	 * @return list of all Reimbursements
	 */

	public List<Reimbursement> getAllReimbursement();
	
	/**
	 * Updates a specific Reimbursement
	 * @param reimb the Reimbursement to update
	 * @return the newly updated Reimbursement object
	 */
	public Reimbursement updateReimbursement(Reimbursement reimb );
	
	/**
	 * Deletes a Reimbursement from the persistence layer
	 * @param reimb the Reimbursement to remove
	 * @return true if successful; false if not
	 */
	public boolean removeReimbursement(Reimbursement reimb);
	
	
	
	
}
