package com.revature.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.User;
import com.revature.utils.ConnectionUtil;

/**
 * Implementation of UserDAO that reads/writes to a relational database
 */
public class UserDaoDB implements UserDao {
	public User addUser(User user) {
		try {
			String sql = "INSERT INTO ers_users(user_id,username,password,first_name,last_name,email,user_role_id) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = ConnectionUtil.getConnectionUtil().getConnection().prepareStatement(sql);
			
			ps.setInt(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getFirstName());
			ps.setString(5, user.getLastName());
			ps.setString(6, user.getEmail());
			ps.setInt(7, user.getUserRoleId());
			
			ps.execute();
			ps.close();
			ConnectionUtil.getConnectionUtil().getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public User getUser(Integer userId) {
		User currentUser = new User();
		try {
			
			String sql = "SELECT * FROM ers_users WHERE user_id = '"+userId+"';";
			Statement s = ConnectionUtil.getConnectionUtil().getConnection().createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				currentUser.setId(rs.getInt(1));
				currentUser.setUsername(rs.getString(2));
				currentUser.setPassword(rs.getString(3));
				currentUser.setFirstName(rs.getString(4));
				currentUser.setLastName(rs.getString(5));
				currentUser.setEmail(rs.getString(6));
				currentUser.setUserRoleId(rs.getInt(7));
			}
			s.close();
			ConnectionUtil.getConnectionUtil().getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return currentUser;
	}

	public User getUser(String username, String pass) {
		User currentUser = new User();
		try {
			
			String sql = "SELECT * FROM ers_users WHERE username = '"+username+"';";
			Statement s = ConnectionUtil.getConnectionUtil().getConnection().createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				currentUser.setId(rs.getInt(1));
				currentUser.setUsername(rs.getString(2));
				currentUser.setPassword(rs.getString(3));
				currentUser.setFirstName(rs.getString(4));
				currentUser.setLastName(rs.getString(5));
				currentUser.setEmail(rs.getString(6));
				currentUser.setUserRoleId(rs.getInt(7));
			}
			s.close();
			ConnectionUtil.getConnectionUtil().getConnection().close();
		} catch (SQLException e) {
			currentUser = null;
		}
		
		
		return currentUser;
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			String sql = "SELECT * FROM ers_users";
			Statement s = ConnectionUtil.getConnectionUtil().getConnection().createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				User currentUser = new User();
				currentUser.setId(rs.getInt(1));
				currentUser.setUsername(rs.getString(2));
				currentUser.setPassword(rs.getString(3));
				currentUser.setFirstName(rs.getString(4));
				currentUser.setLastName(rs.getString(5));
				currentUser.setEmail(rs.getString(6));
				currentUser.setUserRoleId(rs.getInt(7));
				users.add(currentUser);
			}
			s.close();
			ConnectionUtil.getConnectionUtil().getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return users;
	}

	public User updateUser(User u) {
		try {
			String sql = "UPDATE ers_users set first_name = ?,last_name =?,password = ?,email = ? WHERE user_Id = ?";
			PreparedStatement ps = ConnectionUtil.getConnectionUtil().getConnection().prepareStatement(sql);
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3,u.getPassword());
			ps.setString(4, u.getEmail());
			ps.setInt(5, u.getId());
			
			ps.execute();
			ps.close();
			ConnectionUtil.getConnectionUtil().getConnection().close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	public boolean removeUser(User u) {
		try {
			String sql = "DELETE FROM ers_users WHERE user_Id = ?";
			PreparedStatement ps = ConnectionUtil.getConnectionUtil().getConnection().prepareStatement(sql);
			ps.setInt(1, u.getId());
			ps.execute();
			
			ps.close();
			ConnectionUtil.getConnectionUtil().getConnection().close();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
