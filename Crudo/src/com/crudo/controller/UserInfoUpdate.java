package com.crudo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crudo.bo.User;
import com.crudo.dao.UserDao;
import com.crudo.factory.DaoFactory;

public class UserInfoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session
		HttpSession httpSession = request.getSession();
		if(httpSession==null || (httpSession!=null && httpSession.getAttribute("user")==null)) {
			response.sendRedirect("index.jsp?msg=Login Required");
			return;
		}
		User user = (User)httpSession.getAttribute("user");
		
		//fetching params
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		int userId = Integer.parseInt(user.getId());
		
		UserDao userDao = DaoFactory.getUserDao();
		boolean isUpdated = userDao.updateUser(userId, firstname, lastname, email, username, password);
		
		if(isUpdated) {
			String sql ="select * from users where id='"+user.getId()+"'";
			user = userDao.getUser(sql);
			httpSession.setAttribute("user", user);
			response.sendRedirect("userloggedin.jsp?msg=Details Updated Successfully");
		} else {
			response.sendRedirect("userloggedin.jsp?msg=Update Failed Try later");			
		}
		
	}

}
