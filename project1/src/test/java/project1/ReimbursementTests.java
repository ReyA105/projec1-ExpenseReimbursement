package project1;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDao;
import com.revature.services.ReimbursementService;

@RunWith(MockitoJUnitRunner.class)
public class ReimbursementTests {
	@InjectMocks
	public ReimbursementService rService;

	@Mock
	public ReimbursementDao reimbDao;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	private Reimbursement getNewReimbursement() {
		Reimbursement reimb = new Reimbursement();
		reimb.setAmount(150.00);
		reimb.setAuthorId(1);
		reimb.setDescription("test");
		reimb.setReimbId(1);
		reimb.setStatusid(1);
		reimb.setTypeId(2);
		reimb.setResolverid(2);
		return reimb;
	}
	
	List<Reimbursement> rList = new ArrayList<Reimbursement>();
	
	@Test
	public void testApprovalAndDeny() {
		Reimbursement r = getNewReimbursement();
		r.setStatusid(2);
		doReturn(r).when(reimbDao).updateReimbursement(r);
		boolean approved = rService.approveDenyReimbursement(r, true, 1);
		assertTrue(approved);
		assertTrue(2 == r.getStatusid());
		r.setStatusid(3);
		doReturn(r).when(reimbDao).updateReimbursement(r);
		approved = rService.approveDenyReimbursement(r, false, 1);
		assertTrue(approved);
		assertTrue(3 == r.getStatusid());
		
	}
	
	@Test
	public void testViewAllReimbursements() {
		Reimbursement reimb2 = new Reimbursement();
		reimb2.setAmount(100.00);
		reimb2.setAuthorId(1);
		reimb2.setDescription("test2");
		reimb2.setReimbId(1);
		reimb2.setStatusid(1);
		reimb2.setTypeId(1);
		reimb2.setResolverid(2);
		
		rList.add(getNewReimbursement());
		rList.add(reimb2);
		
		doReturn(rList).when(reimbDao).getAllReimbursement();
		List<Reimbursement> fromDao =rService.viewAllReimbursements();
		assertTrue(fromDao.size() == 2);
	}
	
	@Test
	public void testViewEmployeeReimbursements() {
		rList.add(getNewReimbursement());
		doReturn(rList).when(reimbDao).getReimbursementbyAuthor(1);
		List<Reimbursement> fromDao =rService.viewEmployeeReimbursements(1);
		assertTrue(fromDao.size() == 1);
	}
	
	@Test
	public void testaddNewReimbursement() {
		Reimbursement r = getNewReimbursement();
		doReturn(rList).when(reimbDao).getAllReimbursement();
		doReturn(r).when(reimbDao).addReimbursement(r);
		boolean fromDao = rService.addNewReimbursement(r);
		assertTrue(fromDao);
	}
	
	
}
