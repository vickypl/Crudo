package com.crudo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crudo.dao.UserDao;
import com.crudo.factory.DaoFactory;
public class ChangeNewPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession httpSession = request.getSession(false);
		String password = request.getParameter("pwd");
		String cpassword = request.getParameter("npwd");
		
		String email = (String)httpSession.getAttribute("setEmail");
		
		if(!password.equals(cpassword)) {
			response.sendRedirect("passwordrecovery.jsp?msg=Password/Confirm Password are is same.");
			return;
		}
		
		UserDao userDao = DaoFactory.getUserDao();
		boolean isChanged = userDao.changePassword(email, password);
		if(isChanged) {
			response.sendRedirect("passwordrecovery.jsp?msg=Password Successfully Changed");
		} else {
			response.sendRedirect("passwordrecovery.jsp?msg=Failed to Change Password");
		}	
	}

}
