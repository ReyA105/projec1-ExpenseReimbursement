package com.revature.beans;

public class ReimbursementType {
	public static enum ReimbursementTypeID {
		LODGING, TRAVEL, FOOD, OTHER
	}

	public static ReimbursementTypeID ReimbursementTypeID(int typeID) {
		if (typeID == 1)
			return ReimbursementTypeID.LODGING;
		if (typeID == 2)
			return ReimbursementTypeID.TRAVEL;
		if (typeID == 3)
			return ReimbursementTypeID.FOOD;
		return ReimbursementTypeID.OTHER;
	}

	public static int getReimbursementTypeNumber(ReimbursementTypeID reimbtype) {
		if (reimbtype == ReimbursementTypeID.LODGING)
			return 1;
		else if (reimbtype == ReimbursementTypeID.TRAVEL)
			return 2;
		else if (reimbtype == ReimbursementTypeID.FOOD)
			return 3;
		else
			return 4;
	}
}
