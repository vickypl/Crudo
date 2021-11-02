/**
 * 
 */
package com.crudo.dao;

import com.crudo.bo.Admin;

/**
	author: Vicky pl
	email: vicky542011@gmail.com
	mobile: 7828789845
 **/
/**
 * @author Anonymox
 *
 */
public interface AdminDao {
	
	public abstract Admin validateAdmin(String username, String password);
	
	public abstract boolean updateAdmin(int id, String firstname, String lastname, String email, String username, String password);

	public abstract boolean updateLastLogin(int id);
	
}
