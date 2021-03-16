package com.revature.beans;

public class UserRole {
	public static enum UserRoleID{
		EMPLOYEE,MANAGER
	}
	
	public static UserRoleID getUserRoleID(int typeID){
		if(typeID== 1)
			return UserRoleID.EMPLOYEE;
		return UserRoleID.MANAGER;
	}
}
