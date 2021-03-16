package com.revature.services;

import java.util.List;

import com.revature.beans.User;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.UserDao;
import com.revature.exceptions.InvalidCredentialsException;
import com.revature.exceptions.UsernameAlreadyExistsException;
import com.revature.utils.SessionCache;

public class UserService {
	UserDao userDao;
	ReimbursementDao reimbDao;
	
	public UserService(UserDao udao, ReimbursementDao rdao) {
		this.userDao = udao;
		this.reimbDao = rdao;
	}
	
	/**
	 * Validates the username and password, and return the User object for that user
	 * @throws InvalidCredentialsException if either username is not found or password does not match
	 * @return the User who is now logged in
	 */
	public User login(String username, String password) {
		User user = new User();
		user = userDao.getUser(username, password);
		if(user == null)
			throw new InvalidCredentialsException();
		if(!user.getPassword().equals(password))
			throw new InvalidCredentialsException();
		SessionCache.setCurrentUser(user);
		return user;
	}
	
	/**
	 * Creates the specified User in the persistence layer
	 * @param newUser the User to register
	 * @throws UsernameAlreadyExistsException if the given User's username is taken
	 */
	public void register(User newUser) {
		User tempUser = new User();
		tempUser = userDao.getUser(newUser.getUsername(),newUser.getPassword());
		if(tempUser != null) {
			throw new UsernameAlreadyExistsException();
		}
		
		List<User> currentUsers =  userDao.getAllUsers();
		newUser.setId(currentUsers.size()+1);
		
		SessionCache.setCurrentUser(newUser);
		userDao.addUser(newUser);
	}
}
