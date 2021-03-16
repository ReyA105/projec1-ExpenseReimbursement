package com.revature.beans;

public class ReimbursementStatus {
	public static enum ReimbursementStatusID{
		PENDING, APPROVED, DENIED
	}
	
	public static ReimbursementStatusID getReimbursementStatus(int typeID){
		if(typeID == 1)
			return ReimbursementStatusID.PENDING;
		if(typeID == 2)
			return ReimbursementStatusID.APPROVED;
		return ReimbursementStatusID.DENIED;
	}
	public static int getReimbursementStatusNumber(ReimbursementStatusID reimbStatus) {
		if(reimbStatus == ReimbursementStatusID.PENDING)
			return 1;
		else if (reimbStatus == ReimbursementStatusID.APPROVED)
			return 2;
		else
			return 3;
	}
}
