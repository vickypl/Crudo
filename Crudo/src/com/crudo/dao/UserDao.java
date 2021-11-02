/**
 * 
 */
package com.crudo.dao;

import java.util.ArrayList;

import com.crudo.bo.User;

/**
	author: Vicky pl
	email: vicky542011@gmail.com
	mobile: 7828789845
 **/
/**
 * @author Anonymox
 *
 */
public interface UserDao {
	
	public abstract User validateUser(String username, String password);
	
	public abstract boolean addUser(String firstname, String lastname, String email, String username, String password);
	
	public abstract boolean updateUser(int id, String firstname, String lastname, String email, String username, String password);

	public abstract boolean deleteUser(String id);
	
	public abstract User getUser(String sql);
	
	public abstract ArrayList<User> getUserList(String sql);
	
	public abstract boolean updateUserLastLogin(String username);
	
	public abstract boolean isValidUserName(String username);
	
	public abstract boolean blockUser(String id);
	
	public abstract boolean unblockUser(String id);
	
	public abstract boolean changePassword(String email, String newPassword);
}
