/**
 * 
 */
package com.crudo.dao.implemention;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.crudo.bo.Admin;
import com.crudo.dao.AdminDao;
import com.crudo.utility.DatabaseConnector;

/**
	author: Vicky pl
	email: vicky542011@gmail.com
	mobile: 7828789845
 **/
/**
 * @author Anonymox
 *
 */
public class AdminDaoImplementation implements AdminDao {

	String servletname = this.getClass().getName();
	DatabaseConnector db = new DatabaseConnector();
	Connection connection = null;
	PreparedStatement pstat = null;
	Statement statement = null;
	ResultSet resultSet = null;
	/* (non-Javadoc)
	 * @see com.crudo.dao.AdminDao#validateAdmin(java.lang.String, java.lang.String)
	 */
	@Override
	public Admin validateAdmin(String username, String password) {
		Admin admin = null;
		try {
			connection = db.getConnect();
			String sql = "select * from admin where username='"+username+"' or email='"+username+"' and password='"+password+"'";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			if(resultSet.next()) {
				admin = new Admin();
				admin.setId(resultSet.getString(1));
				admin.setFirstname(resultSet.getString(2));
				admin.setLastname(resultSet.getString(3));
				admin.setEmail(resultSet.getString(4));
				admin.setUsername(resultSet.getString(5));
				admin.setPassword(resultSet.getString(6));
				admin.setRole(resultSet.getString(7));
				admin.setLastlogin(resultSet.getString(8));
				admin.setSignupdate(resultSet.getString(9));
			}
			
		} catch (SQLException e) {
			db.logToFile(e, servletname);
		} catch (Exception e) {
			db.logToFile(e, servletname);
		}
		return admin;
	}


	/* (non-Javadoc)
	 * @see com.crudo.dao.AdminDao#updateAdmin(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean updateAdmin(int id, String firstname, String lastname, String email, String username, String password) {
		username=username.toLowerCase();
		boolean status= false;
		try {
			connection = db.getConnect();
			String sql="update admin set firstname=?, lastname=?, email=?, username=?, password=? where id=?";
			pstat = connection.prepareStatement(sql);
			pstat.setString(1, firstname);
			pstat.setString(2, lastname);
			pstat.setString(3, email);
			pstat.setString(4, username);
			pstat.setString(5, password);
			pstat.setInt(6, id);
			
			int result = pstat.executeUpdate();
			
			if(result>0) {
				status = true;
			}
			
		} catch (SQLException e) {
			db.logToFile(e, servletname);
		} catch (Exception e) {
			db.logToFile(e, servletname);
		}
		return status;
	}

	/* (non-Javadoc)
	 * @see com.crudo.dao.AdminDao#updateLastLogin()
	 */
	@Override
	public boolean updateLastLogin(int id) {
		boolean status= false;
		try {
			connection = db.getConnect();
			String sql="update admin set lastlogin=SYSDATE where id="+id;
			statement = connection.createStatement();
			
			int result = statement.executeUpdate(sql);
			
			if(result>0) {
				status = true;
			}
			
		} catch (SQLException e) {
			db.logToFile(e, servletname);
		} catch (Exception e) {
			db.logToFile(e, servletname);
		}
		return status;
	}
	
}
