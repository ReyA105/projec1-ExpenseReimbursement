package project1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.revature.beans.Reimbursement;
import com.revature.beans.User;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoDB;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoDB;


public class DatabaseIntegrationTests {
	ReimbursementDao rdao = new ReimbursementDaoDB();
	Reimbursement testReimbursement = new Reimbursement();
	UserDao udao = new UserDaoDB();
	User testUser = new User();
	
	@Before
	public void setupReimbursementAndUser() {
		testUser.setId(1);
		testUser.setEmail("r@gmail.com");
		testUser.setFirstName("r");
		testUser.setLastName("a");
		testUser.setPassword("tempPassword");
		testUser.setUsername("tempUser");
		testUser.setUserRoleId(1);
		udao.addUser(testUser);
		
		testReimbursement.setAmount(150.00);
		testReimbursement.setAuthorId(1);
		testReimbursement.setDescription("this is necesaary");
		testReimbursement.setReimbId(1);
		testReimbursement.setSubmitted(Timestamp.from(Instant.now().truncatedTo(ChronoUnit.MINUTES)));
		testReimbursement.setStatusid(1);
		testReimbursement.setTypeId(1);
		rdao.addReimbursement(testReimbursement);
		
	}
	
	@After
	public void tearDown() throws IOException{
		rdao.removeReimbursement(testReimbursement);
		udao.removeUser(testUser);
	
	}
	/*
	 * REIMBURSEMENT INTEGRATION TESTS
	 */
	
	@Test
	public void testAddAndGetReimbursmentbyAuthor() {
		List<Reimbursement> fromDB = rdao.getReimbursementbyAuthor(testReimbursement.getAuthorId());
		assertEquals(testReimbursement, fromDB.get(0));
	}
	
	@Test
	public void testAddAndGetReimbursmentbyID() {
		Reimbursement fromDB = rdao.getReimbursementbyID(testReimbursement.getReimbId());
		assertEquals(testReimbursement, fromDB);
	}
	@Test
	public void testgetAllReimbursement() {
		Reimbursement secondReimb = new Reimbursement();
		
		secondReimb.setAmount(50.00);
		secondReimb.setAuthorId(1);
		secondReimb.setDescription("this is second");
		secondReimb.setReimbId(2);
		secondReimb.setSubmitted(Timestamp.from(Instant.now().truncatedTo(ChronoUnit.MINUTES)));
		secondReimb.setStatusid(1);
		secondReimb.setTypeId(2);
		rdao.addReimbursement(secondReimb);
		List<Reimbursement> allReimb = rdao.getAllReimbursement();
		rdao.removeReimbursement(secondReimb);		
		
		assertEquals(allReimb.size(),2);
	}
	
	@Test
	public void testUpdateReimbursement() {
		testReimbursement.setDescription("new description");
		testReimbursement.setAmount(2000.00);
		rdao.updateReimbursement(testReimbursement);
		Reimbursement updatedReimb = rdao.getReimbursementbyID(testReimbursement.getReimbId());
		assertEquals(updatedReimb,testReimbursement);
	}
	
	@Test
	public void testRemoveReimbursement() {
		boolean success = rdao.removeReimbursement(testReimbursement);
		if (success) {
			assertEquals(rdao.getAllReimbursement().size(), 0);
		} else {
			fail("Unable to delete account");
		}
	}
	/*
	 * USER INTEGRATION TESTS
	 */
	
	@Test
	public void testAddAndGetUser() {
		User fromDB = udao.getUser(testUser.getId());
		assertEquals(testUser, fromDB);
	}
	
	
	@Test
	public void testGetAllUsers() {
		User second = new User();
		second.setId(2);
		second.setEmail("new@gmail.com");
		second.setFirstName("r");
		second.setLastName("a");
		second.setPassword("tempPassword");
		second.setUsername("newUser");
		second.setUserRoleId(1);
		udao.addUser(second);
		List<User> allUsers = udao.getAllUsers();
		udao.removeUser(second);
		assertEquals(allUsers.size(), 2);
	}
	
	@Test
	public void testUpdateUser() {
		testUser.setFirstName("Charlie");
		udao.updateUser(testUser);
		assertEquals(udao.getUser(testUser.getId()).getFirstName(), "Charlie");
	}
	
	@Test
	public void testDeleteUser() {
		User second = new User();
		second.setId(2);
		second.setEmail("new@gmail.com");
		second.setFirstName("r");
		second.setLastName("a");
		second.setPassword("tempPassword");
		second.setUsername("newUser");
		second.setUserRoleId(1);
		udao.addUser(second);
		
		boolean success = udao.removeUser(second);
		if (success) {
			assertEquals(udao.getAllUsers().size(), 1);
		} else {
			fail("Unable to delete account");
		}
	}
}
