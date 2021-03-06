package com.revature.beans;

public class User {
	public static enum UserRole{
		EMPLOYEE,MANAGER
	}
	
	private Integer id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private Integer userRoleId;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getUserRoleId() {
		return userRoleId;
	}
	
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if(userRoleId == null) {
			if(other.userRoleId != null)
				return false;
		}else if(!userRoleId.equals(other.userRoleId))
			return false;
		
		if(email == null) {
			if(other.email == null)
				return false;
		}else if(!email.equals(other.email))
			return false;
		
		if(lastName == null) {
			if(other.lastName == null)
				return false;
		}else if(!lastName.equals(other.lastName))
			return false;
		
		if(firstName == null) {
			if(other.firstName == null)
				return false;
		}else if(!firstName.equals(other.firstName))
			return false;
		
		if(password == null) {
			if(other.password == null)
				return false;
		}else if(!password.equals(other.password))
			return false;
		
		if(username == null) {
			if(other.username == null)
				return false;
		}else if(!username.equals(other.username))
			return false;
		
		if(id == null) {
			if(other.id == null)
				return false;
		}else if(!id.equals(other.id))
			return false;
		
		
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", userRoleId=" + userRoleId + "]";
	}
	
}
