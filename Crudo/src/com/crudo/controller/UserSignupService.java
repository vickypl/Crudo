package com.crudo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crudo.dao.UserDao;
import com.crudo.factory.DaoFactory;

public class UserSignupService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String firstname = request.getParameter("fname");
			String lastname = request.getParameter("lname");
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			UserDao userDao = DaoFactory.getUserDao();
			boolean isAdded = userDao.addUser(firstname, lastname, email, username, password);
			if(isAdded) {
				response.sendRedirect("index.jsp?msg=SignUp Successfull , Login now");
			} else {
				response.sendRedirect("index.jsp?msg=Problem in SigingUp, try later");
			}
	}

}
