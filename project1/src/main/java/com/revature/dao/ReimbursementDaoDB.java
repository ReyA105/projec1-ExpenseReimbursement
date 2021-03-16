package com.revature.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.utils.ConnectionUtil;

public class ReimbursementDaoDB implements ReimbursementDao {

	public Reimbursement addReimbursement(Reimbursement reimb) {
		try {
			String sql = "INSERT INTO ERS_REIMBURSEMENT(reimb_id,amount,submitted,description,author,status_id,type_id) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = ConnectionUtil.getConnectionUtil().getConnection().prepareStatement(sql);

			ps.setInt(1, reimb.getReimbId());
			ps.setDouble(2, reimb.getAmount());
			ps.setTimestamp(3, reimb.getSubmitted());
			ps.setString(4, reimb.getDescription());
			ps.setInt(5, reimb.getAuthorId());
			ps.setInt(6, reimb.getStatusid());
			ps.setInt(7, reimb.getTypeId());

			ps.execute();
			ps.close();
			ConnectionUtil.getConnectionUtil().getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}

	public List<Reimbursement> getReimbursementbyAuthor(Integer userId) {
		List<Reimbursement> currentReimb = new ArrayList<Reimbursement>();
		try {

			String sql = "SELECT * FROM ers_Reimbursement WHERE author = '" + userId + "';";
			Statement s = ConnectionUtil.getConnectionUtil().getConnection().createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				Reimbursement tempReimb = new Reimbursement();
				tempReimb.setReimbId(rs.getInt(1));
				tempReimb.setAmount(rs.getDouble(2));
				tempReimb.setSubmitted(rs.getTimestamp(3));
				tempReimb.setResolved(rs.getTimestamp(4));
				tempReimb.setDescription(rs.getString(5));
				// currentReimb.setReceipt(rs.getByte(6));
				tempReimb.setAuthorId(rs.getInt(7));
				if (rs.getInt(8) == 0) {
					tempReimb.setResolverid(null);
				} else {
					tempReimb.setResolverid(rs.getInt(8));
				}
				tempReimb.setStatusid(rs.getInt(9));
				tempReimb.setTypeId(rs.getInt(10));
				currentReimb.add(tempReimb);
			}
			s.close();
			ConnectionUtil.getConnectionUtil().getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return currentReimb;
	}

	public Reimbursement getReimbursementbyID(Integer reimbId) {
		Reimbursement currentReimb = new Reimbursement();
		try {

			String sql = "SELECT * FROM ers_Reimbursement WHERE reimb_id = '" + reimbId + "';";
			Statement s = ConnectionUtil.getConnectionUtil().getConnection().createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				currentReimb.setReimbId(rs.getInt(1));
				currentReimb.setAmount(rs.getDouble(2));
				currentReimb.setSubmitted(rs.getTimestamp(3));
				currentReimb.setResolved(rs.getTimestamp(4));
				currentReimb.setDescription(rs.getString(5));
				// currentReimb.setReceipt(rs.getByte(6));
				currentReimb.setAuthorId(rs.getInt(7));
				if (rs.getInt(8) == 0) {
					currentReimb.setResolverid(null);
				} else {
					currentReimb.setResolverid(rs.getInt(8));
				}
				currentReimb.setStatusid(rs.getInt(9));
				currentReimb.setTypeId(rs.getInt(10));
			}
			s.close();
			ConnectionUtil.getConnectionUtil().getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return currentReimb;
	}

	public List<Reimbursement> getAllReimbursement() {
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		
		try {
			String sql = "SELECT * FROM ers_reimbursement";
			Statement s = ConnectionUtil.getConnectionUtil().getConnection().createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				Reimbursement currentReimb = new Reimbursement();
				currentReimb.setReimbId(rs.getInt(1));
				currentReimb.setAmount(rs.getDouble(2));
				currentReimb.setSubmitted(rs.getTimestamp(3));
				currentReimb.setResolved(rs.getTimestamp(4));
				currentReimb.setDescription(rs.getString(5));
				// currentReimb.setReceipt(rs.getByte(6));
				currentReimb.setAuthorId(rs.getInt(7));
				currentReimb.setResolverid(rs.getInt(8));
				currentReimb.setStatusid(rs.getInt(9));
				currentReimb.setTypeId(rs.getInt(10));
				reimbs.add(currentReimb);
			}
			s.close();
			ConnectionUtil.getConnectionUtil().getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

	public Reimbursement updateReimbursement(Reimbursement reimb) {
		try {
			String sql = "UPDATE ers_reimbursement set amount =?, resolved =?, description =?,resolver =?,status_id =?,type_id =? WHERE reimb_id = ?";
			PreparedStatement ps = ConnectionUtil.getConnectionUtil().getConnection().prepareStatement(sql);

			ps.setDouble(1, reimb.getAmount());
			ps.setTimestamp(2, reimb.getResolved());
			ps.setString(3, reimb.getDescription());
			if (reimb.getResolverid() == null)
				ps.setNull(4, java.sql.Types.INTEGER);
			else
				ps.setInt(4, reimb.getResolverid());
			ps.setInt(5, reimb.getStatusid());
			ps.setInt(6, reimb.getTypeId());
			ps.setInt(7, reimb.getReimbId());

			ps.execute();
			ps.close();
			ConnectionUtil.getConnectionUtil().getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}

	public boolean removeReimbursement(Reimbursement reimb) {
		try {
			String sql = "DELETE FROM ers_reimbursement WHERE reimb_id = ?";
			PreparedStatement ps = ConnectionUtil.getConnectionUtil().getConnection().prepareStatement(sql);
			ps.setInt(1, reimb.getReimbId());
			ps.execute();
			ps.close();
			ConnectionUtil.getConnectionUtil().getConnection().close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
