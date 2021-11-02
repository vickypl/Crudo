/**
 * 
 */
package com.crudo.dao.implemention;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.crudo.bo.User;
import com.crudo.dao.UserDao;
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
public class UserDaoImplementation implements UserDao {

	String servletname = this.getClass().getName();
	DatabaseConnector db = new DatabaseConnector();
	Connection connection = null;
	PreparedStatement pstat = null;
	Statement statement = null;
	ResultSet resultSet = null;
	/* (non-Javadoc)
	 * @see com.crudo.dao.UserDao#validateUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User validateUser(String username, String password) {
		User user = null;
		try {
			connection = db.getConnect();
			String sql = "select * from users where username='"+username+"' or email='"+username+"' and password='"+password+"'";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			if(resultSet.next()) {
				user = new User();
				user.setId(resultSet.getString(1));
				user.setFirstname(resultSet.getString(2));
				user.setLastname(resultSet.getString(3));
				user.setEmail(resultSet.getString(4));
				user.setUsername(resultSet.getString(5));
				user.setPassword(resultSet.getString(6));
				user.setRole(resultSet.getString(7));
				user.setBlocking(resultSet.getString(8));
				user.setLastlogin(resultSet.getString(9));
				user.setSignup(resultSet.getString(10));
			}
			
		} catch (SQLException e) {
			db.logToFile(e, servletname);
		} catch (Exception e) {
			db.logToFile(e, servletname);
		}
		return user;
	}

	/* (non-Javadoc)
	 * @see com.crudo.dao.UserDao#addUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addUser(String firstname, String lastname, String email, String username, String password) {
		username = username.toLowerCase();
		boolean status= false;
		try {
			connection = db.getConnect();
			String sql = "insert into users(id, firstname, lastname, email, username, password, role, blocking, lastlogin, signupdate) values(user_id.nextval, ?, ?, ?, ?, ?, 'user', 'unblocked', SYSDATE, SYSDATE)";
			pstat = connection.prepareStatement(sql);
			pstat.setString(1, firstname);
			pstat.setString(2, lastname);
			pstat.setString(3, email);
			pstat.setString(4, username);
			pstat.setString(5, password);
			
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
	 * @see com.crudo.dao.UserDao#updateUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean updateUser(int id, String firstname, String lastname, String email, String username, String password) {
		boolean status= false;
		try {
			connection = db.getConnect();
			String sql="update users set firstname=?, lastname=?, email=?, username=?, password=? where id=?";
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
	 * @see com.crudo.dao.UserDao#deleteUser(java.lang.String)
	 */
	@Override
	public boolean deleteUser(String id) {
		boolean status= false;
		try {
			connection = db.getConnect();
			String sql="delete from users where id='"+id+"'";
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

	/* (non-Javadoc)
	 * @see com.crudo.dao.UserDao#getUser(java.lang.String)
	 */
	@Override
	public User getUser(String sql) {
		User user = null;
		try {
			connection = db.getConnect();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			if(resultSet.next()) {
				user = new User();
				user.setId(resultSet.getString(1));
				user.setFirstname(resultSet.getString(2));
				user.setLastname(resultSet.getString(3));
				user.setEmail(resultSet.getString(4));
				user.setUsername(resultSet.getString(5));
				user.setPassword(resultSet.getString(6));
				user.setRole(resultSet.getString(7));
				user.setBlocking(resultSet.getString(8));
				user.setLastlogin(resultSet.getString(9));
				user.setSignup(resultSet.getString(10));
			}
			
		} catch (SQLException e) {
			db.logToFile(e, servletname);
		} catch (Exception e) {
			db.logToFile(e, servletname);
		}
		return user;
	}

	/* (non-Javadoc)
	 * @see com.crudo.dao.UserDao#getUserList(java.lang.String)
	 */
	@Override
	public ArrayList<User> getUserList(String sql) {
		ArrayList<User> userList = new ArrayList<User>();
		try {
			connection = db.getConnect();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			User user = null;
			while(resultSet.next()) {
				user  = new User();
				user.setId(resultSet.getString(1));
				user.setFirstname(resultSet.getString(2));
				user.setLastname(resultSet.getString(3));
				user.setEmail(resultSet.getString(4));
				user.setUsername(resultSet.getString(5));
				user.setPassword(resultSet.getString(6));
				user.setRole(resultSet.getString(7));
				user.setBlocking(resultSet.getString(8));
				user.setLastlogin(resultSet.getString(9));
				user.setSignup(resultSet.getString(10));
				userList.add(user);
			}
			
		} catch (SQLException e) {
			db.logToFile(e, servletname);
		} catch (Exception e) {
			db.logToFile(e, servletname);
		}
		return userList;
	}

	/* (non-Javadoc)
	 * @see com.crudo.dao.UserDao#updateUserLastLogin(java.lang.String)
	 */
	@Override
	public boolean updateUserLastLogin(String username) {
		boolean status= false;
		try {
			connection = db.getConnect();
			String sql="update users set lastlogin=SYSDATE where username='"+username+"'";
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

	/* (non-Javadoc)
	 * @see com.crudo.dao.UserDao#isValidUserName(java.lang.String)
	 */
	@Override
	public boolean isValidUserName(String username) {
		boolean status =false;
		try {
			connection = db.getConnect();
			String sql = "select * from users where username='"+username+"'";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			if(resultSet.next()) {
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
	 * @see com.crudo.dao.UserDao#blockUser(java.lang.String)
	 */
	@Override
	public boolean blockUser(String id) {
		boolean status =false;
		try {
			connection = db.getConnect();
			String sql = "update users set blocking='blocked' where id='"+id+"'";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			if(resultSet.next()) {
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
	 * @see com.crudo.dao.UserDao#unblockUser(java.lang.String)
	 */
	@Override
	public boolean unblockUser(String id) {
		boolean status =false;
		try {
			connection = db.getConnect();
			String sql = "update users set blocking='unblocked' where id='"+id+"'";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			if(resultSet.next()) {
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
	 * @see com.crudo.dao.UserDao#changePassword()
	 */
	@Override
	public boolean changePassword(String email, String newPassword) {
		boolean status =false;
		try {
			connection = db.getConnect();
			String sql = "update users set password='"+newPassword+"' where email='"+email+"'";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			if(resultSet.next()) {
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