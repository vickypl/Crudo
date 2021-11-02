package com.crudo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crudo.dao.UserDao;
import com.crudo.factory.DaoFactory;

public class UsernameAvailablity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("uname");
		
		UserDao userDao = DaoFactory.getUserDao();
		boolean isAvailible = userDao.isValidUserName(username);
		
		response.setContentType("texthtml");
		PrintWriter out = response.getWriter();
		
		if (!isAvailible) {
			out.print("<span style='color: green;'>Username is Availible</span>");
		} else {			
			out.print("<span style='color: red;'>Username Not Availible</span>");
		}
	}

}
