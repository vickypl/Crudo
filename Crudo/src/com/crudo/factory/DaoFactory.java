/**
 * 
 */
package com.crudo.factory;

import com.crudo.dao.AdminDao;
import com.crudo.dao.TodoDao;
import com.crudo.dao.UserDao;
import com.crudo.dao.implemention.AdminDaoImplementation;
import com.crudo.dao.implemention.TodoDaoImplementation;
import com.crudo.dao.implemention.UserDaoImplementation;

/**
	author: Vicky pl
	email: vicky542011@gmail.com
	mobile: 7828789845
 **/
/**
 * @author Anonymox
 *
 */
public final class DaoFactory {

	private static AdminDao adminDao = null;
	public static AdminDao getAdminDao() {
		if(adminDao == null) {
			adminDao = new AdminDaoImplementation();
		}
		return adminDao;
	}
	
	private static UserDao userDao = null;
	public static UserDao getUserDao() {
		if(userDao==null) {
			userDao=new UserDaoImplementation();
		}
		return userDao;
	}
	
	private static TodoDao todoDao = null;
	public static TodoDao getTodoDao() {
		if(todoDao==null) {
			todoDao = new TodoDaoImplementation();
		}
		return todoDao;
	}
}
