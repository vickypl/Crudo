package com.crudo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crudo.bo.User;
import com.crudo.dao.UserDao;
import com.crudo.factory.DaoFactory;

public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username =  request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDao userDao = DaoFactory.getUserDao();
		
		User user = userDao.validateUser(username, password);
		if(user!=null) {
			if(user.getBlocking().equals("unblocked")) {
				HttpSession session = request.getSession(true);
				session.setAttribute("user", user);
				userDao.updateUserLastLogin(user.getUsername());
				request.setAttribute("msg", "Welcome "+user.getUsername());
				RequestDispatcher rd = request.getRequestDispatcher("userloggedin.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("msg", "You Are Blocked Try Later");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		} else {
			request.setAttribute("msg", "Username or Password Invalid");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

}
